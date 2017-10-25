package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.enums.OrderStatus;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "currency")
    private String currency;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;

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

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
}
