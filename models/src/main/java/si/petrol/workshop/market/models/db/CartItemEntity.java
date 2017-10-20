package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
@Entity
@Table(name = "cart_items")
public class CartItemEntity extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "prive")
    private BigDecimal price;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Column(name = "curency")
    private String currency;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
