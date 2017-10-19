package mappers;

import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.models.db.CartEntity;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.models.db.OrderEntity;

public class OrderMapper {

    public static Order toOrder(OrderEntity orderEntity) {

        if (orderEntity == null) return null;

        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setCreatedAt(orderEntity.getCreatedAt());
        order.setUpdatedAt(orderEntity.getUpdatedAt());
        order.setStatus(orderEntity.getStatus());
        order.setTotal(orderEntity.getTotal());
        order.setCurrency(orderEntity.getCurrency());
        order.setCart(CartMapper.toCart(orderEntity.getCart()));
        order.setCustomer(CustomerMapper.toCustomer(orderEntity.getCustomer()));
        order.setTransaction(TransactionMapper.toTransaction(orderEntity.getTransaction()));

        return order;
    }

    public static OrderEntity toOrderEntity(Order order, OrderEntity orderEntity) {

        if (order == null) return null;

        if (order.getCart() != null && order.getCart().getId() != null) {

            CartEntity cartEntity = new CartEntity();
            cartEntity.setId(order.getCart().getId());

            orderEntity.setCart(cartEntity);
        }

        if (order.getCustomer() != null && order.getCustomer().getId() != null) {

            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(order.getCustomer().getId());

            orderEntity.setCustomer(customerEntity);
        }

        return orderEntity;
    }
}
