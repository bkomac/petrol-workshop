package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.mappers.CartMapper;
import si.petrol.workshop.market.models.db.CartEntity;
import si.petrol.workshop.market.models.db.CartItemEntity;
import si.petrol.workshop.market.models.db.ProductEntity;
import si.petrol.workshop.market.services.CartService;
import si.petrol.workshop.market.services.beans.MarketErrorCode;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class CartServiceImpl implements CartService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Cart findCartById(String id) {

        CartEntity cartEnt = em.find(CartEntity.class, id);
        return CartMapper.toCart(cartEnt);
    }

    @Override
    public Cart createCart() {
        CartEntity cartEnt = new CartEntity();
        cartEnt.setExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS));

        em.getTransaction().begin();
        em.persist(cartEnt);
        em.getTransaction().commit();

        return CartMapper.toCart(cartEnt);
    }

    @Override
    public Cart addItemToCartById(CartItem catrtItem, String cartId) throws Exception {

        CartEntity cartEntity = em.find(CartEntity.class, cartId);
        if (cartEntity == null)
            throw new ResourceNotFoundException("Vozliček ne obstaja, še.");

        if (cartEntity.getExpiresAt().isAfter(Instant.now().plus(1, ChronoUnit.HOURS)))
            throw new MarketException(MarketErrorCode.CART_EXPIRED);

        CartItemEntity cartItemEntity = CartMapper.toCartItemEntity(catrtItem, new CartItemEntity());


        if (cartItemEntity.getQuantity() == null || cartItemEntity.getQuantity().compareTo(BigDecimal.ZERO) < 0)
            cartItemEntity.setQuantity(BigDecimal.ONE);


        if (cartItemEntity.getProduct() == null)
            throw new ResourceNotFoundException("Ni produkta sploh...");

        ProductEntity productEnt = em.find(ProductEntity.class, cartItemEntity.getProduct().getId());

        if (productEnt == null)
            throw new ResourceNotFoundException("Ni produkta...");

        Set<CartItemEntity> cartItems = cartEntity.getItems() != null ?
                cartEntity.getItems() : new HashSet<>();

        Boolean productExists = cartItems.stream()
                .anyMatch(ci -> ci.getProduct().getId()
                        .equals(productEnt.getId()));

        if (productExists)
            throw new MarketException(MarketErrorCode.CART_ITEM_ALLREADY_IN_CART);

        cartItemEntity.setCart(cartEntity);
        cartItemEntity.setProduct(productEnt);
        cartItemEntity.setCurrency(productEnt.getCurrency());
        cartItemEntity.setPrice(productEnt.getPrice());
        cartItemEntity.setTitle(productEnt.getTitle());
        cartItemEntity.setAmount(cartItemEntity.getQuantity()
                .multiply(productEnt.getPrice())
                .setScale(2, BigDecimal.ROUND_HALF_EVEN));

        cartItems.add(cartItemEntity);
        em.getTransaction().begin();
        em.persist(cartItemEntity);
        em.getTransaction().commit();

        return CartMapper.toCart(cartEntity);
    }

    @Override
    public Cart removeItemFromCart(String cartId, String itemId) {
        return null;
    }
}
