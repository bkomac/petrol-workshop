package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;

import java.math.BigDecimal;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class CartItem extends BaseType {

    private String title;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal quantity;
    private String currency;
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
