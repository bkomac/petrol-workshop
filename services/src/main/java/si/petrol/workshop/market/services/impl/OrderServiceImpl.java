package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.integrations.ExchangeRatesClient;
import si.petrol.workshop.market.integrations.ProcessorClient;
import si.petrol.workshop.market.integrations.beans.Rate;
import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.lib.enums.OrderStatus;
import si.petrol.workshop.market.mappers.OrderMapper;
import si.petrol.workshop.market.models.db.CartEntity;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.models.db.OrderEntity;
import si.petrol.workshop.market.models.db.TransactionEntity;
import si.petrol.workshop.market.services.OrderService;
import si.petrol.workshop.market.services.beans.MarketErrorCode;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;
import si.petrol.workshop.market.services.interceptors.RollBack;
import si.petrol.workshop.market.services.workers.QueueManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.smartcardio.CardException;
import java.math.BigDecimal;
import java.time.Instant;

@ApplicationScoped
@RollBack
public class OrderServiceImpl implements OrderService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ExchangeRatesClient clinent;

    @Inject
    private ProcessorClient procClient;

    @Inject
    private QueueManager manager;


    @Override
    public Order findOrderById(String id) {
        OrderEntity orderEnt = em.find(OrderEntity.class, id);
        return OrderMapper.toOrder(orderEnt);
    }

    @Override
    public Order createOrder(Order order) {
        OrderEntity orderEnt = OrderMapper.toOrderEntity(order, new OrderEntity());

        if (orderEnt.getCart() == null)
            throw new ResourceNotFoundException("Ni vozlička...");

        CartEntity cartEnt = em.find(CartEntity.class, orderEnt.getCart().getId());

        if (cartEnt == null)
            throw new ResourceNotFoundException("Vozlička ni v bazi...");

        if (cartEnt.getExpiresAt().isBefore(Instant.now()))
            throw new MarketException(MarketErrorCode.CART_EXPIRED);

        orderEnt.setCart(cartEnt);

        CustomerEntity customerEnt = em.find(CustomerEntity.class, orderEnt.getCustomer().getId());

        if (customerEnt == null)
            throw new ResourceNotFoundException("Ni kustomerja...");

        orderEnt.setCustomer(customerEnt);
        orderEnt.setStatus(OrderStatus.NEW);


        em.getTransaction().begin();
        em.persist(orderEnt);
        em.getTransaction().commit();

        return OrderMapper.toOrder(orderEnt);
    }

    @Override
    public Order cancelOrder(String id) {

        OrderEntity orderEnt = em.find(OrderEntity.class, id);

        orderEnt.setStatus(OrderStatus.CANCELED);

        em.getTransaction().begin();
        em.persist(orderEnt);
        em.getTransaction().commit();


        return OrderMapper.toOrder(orderEnt);
    }

    @Override
    public Order completeOrder(String id) {

        em.getTransaction().begin();

        OrderEntity orderEnt = em.find(OrderEntity.class, id);

        if (orderEnt == null)
            throw new ResourceNotFoundException("Ni takega naročila");

        if (!orderEnt.getStatus().equals(OrderStatus.NEW))
            throw new MarketException(MarketErrorCode.ORDER_INCORRECT_STATE);

        if (orderEnt.getCart().getItems() == null || orderEnt.getCart().getItems().isEmpty())
            throw new MarketException(MarketErrorCode.ORDER_CART_EMPTY);

        BigDecimal finalPrice = orderEnt.getCart().getItems().stream().map(i -> {
            if (i.getCurrency().equals("EUR")) {
                return i.getAmount();
            } else {

                //get latest exchange rate
                //BigDecimal rate = new BigDecimal("0.5");

                Rate rate = clinent.findRateByCurrency(i.getCurrency());

                return i.getAmount().multiply(rate.getRates().getEur())
                        .setScale(2, BigDecimal.ROUND_HALF_EVEN);
            }
        }).reduce(BigDecimal.ZERO, (c, n) -> n.add(c));

        orderEnt.setTotal(finalPrice);
        orderEnt.setCurrency("EUR");

        //izvedi transakcijo
        TransactionEntity tr = new TransactionEntity();
        tr.setAmount(orderEnt.getTotal());
        tr.setCurrency(orderEnt.getCurrency());

        procClient.executeTransaction(tr);


        if (tr.getStatus().equals(OrderStatus.COMPLETED))
            orderEnt.setStatus(OrderStatus.COMPLETED);
        else
            orderEnt.setStatus(OrderStatus.FAILED);

        em.persist(tr);

        orderEnt.setTransaction(tr);

        em.getTransaction().commit();

        //send to rabittMq
        manager.enqueueCompletedOrder(orderEnt);

        return OrderMapper.toOrder(orderEnt);
    }
}
