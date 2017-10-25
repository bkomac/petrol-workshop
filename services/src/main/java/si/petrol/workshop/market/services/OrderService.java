package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.services.interceptors.RollBack;

@RollBack
public interface OrderService {

    Order findOrderById(String id);

    Order createOrder(Order order);

    Order cancelOrder(String id);

    Order completeOrder(String id);
}
