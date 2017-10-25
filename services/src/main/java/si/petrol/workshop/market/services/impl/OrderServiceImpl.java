package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.lib.enums.OrderStatus;
import si.petrol.workshop.market.mappers.OrderMapper;
import si.petrol.workshop.market.models.db.CartEntity;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.models.db.OrderEntity;
import si.petrol.workshop.market.services.OrderService;
import si.petrol.workshop.market.services.beans.MarketErrorCode;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;
import si.petrol.workshop.market.services.interceptors.RollBack;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.smartcardio.CardException;
import java.time.Instant;

@ApplicationScoped
@RollBack
public class OrderServiceImpl implements OrderService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Order findOrderById(String id) {
        OrderEntity orderEnt = em.find(OrderEntity.class, id);
        return OrderMapper.toOrder(orderEnt);
    }

    @Override
    public Order createOrder(Order order) throws ResourceNotFoundException, MarketException {
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
        return null;
    }
}
