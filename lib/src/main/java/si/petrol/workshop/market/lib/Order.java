package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.lib.enums.OrderStatus;

import java.math.BigDecimal;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Order extends BaseType {

    private OrderStatus status;
    private BigDecimal total;
    private String currency;
    private Cart cart;
    private Customer customer;
    private Transaction transaction;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
