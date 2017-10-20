package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

public interface CartService {

    Cart findCartById(String id);

    Cart createCart();

    Cart addItemToCartById(CartItem catrtItem, String cartId) throws Exception;

    Cart removeItemFromCart(String cartId, String itemId) throws ResourceNotFoundException;


}
