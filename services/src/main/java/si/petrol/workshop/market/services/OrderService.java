package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;
import si.petrol.workshop.market.services.interceptors.RollBack;

import javax.smartcardio.CardException;

@RollBack
public interface OrderService {

    Order findOrderById(String id);

    Order createOrder(Order order) throws ResourceNotFoundException, CardException, MarketException;

    Order cancelOrder(String id);

    Order completeOrder(String id) throws ResourceNotFoundException, MarketException;
}
