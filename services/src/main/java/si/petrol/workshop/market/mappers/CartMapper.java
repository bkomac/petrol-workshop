package si.petrol.workshop.market.mappers;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.models.db.CartEntity;
import si.petrol.workshop.market.models.db.CartItemEntity;
import si.petrol.workshop.market.models.db.ProductEntity;

import java.util.stream.Collectors;

public class CartMapper {

    public static Cart toCart(CartEntity cartEntity) {

        if (cartEntity == null) return null;

        Cart cart = new Cart();
        cart.setId(cartEntity.getId());
        cart.setUpdatedAt(cartEntity.getUpdatedAt());
        cart.setCreatedAt(cartEntity.getCreatedAt());
        cart.setExpiresAt(cartEntity.getExpiresAt());

        if (cartEntity.getItems() != null && !cartEntity.getItems().isEmpty()) {

            cart.setItems(cartEntity.getItems().stream().map(CartMapper::toCartItem).collect(Collectors.toSet()));
        }

        return cart;
    }

    public static CartEntity toCartEntity(Cart cart, CartEntity cartEntity) {

        if (cart == null) return null;

        cartEntity.setExpiresAt(cart.getExpiresAt());

        return cartEntity;
    }

    private static CartItem toCartItem(CartItemEntity cartItemEntity) {

        if (cartItemEntity == null) return null;

        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemEntity.getId());
        cartItem.setUpdatedAt(cartItemEntity.getUpdatedAt());
        cartItem.setCreatedAt(cartItemEntity.getCreatedAt());
        cartItem.setTitle(cartItemEntity.getTitle());
        cartItem.setAmount(cartItemEntity.getAmount());
        cartItem.setPrice(cartItemEntity.getPrice());
        cartItem.setCurrency(cartItemEntity.getCurrency());
        cartItem.setQuantity(cartItemEntity.getQuantity());

        if (cartItemEntity.getProduct() != null) {

            Product product = new Product();
            product.setId(cartItemEntity.getProduct().getId());

            cartItem.setProduct(product);
        }

        return cartItem;
    }

    public static CartItemEntity toCartItemEntity(CartItem cartItem, CartItemEntity cartItemEntity) {

        if (cartItem == null || cartItemEntity == null) return null;

        cartItemEntity.setQuantity(cartItem.getQuantity());

        if (cartItem.getProduct() != null) {

            ProductEntity productEntity = new ProductEntity();
            productEntity.setId(cartItem.getProduct().getId());

            cartItemEntity.setProduct(productEntity);
        }

        return cartItemEntity;
    }
}
