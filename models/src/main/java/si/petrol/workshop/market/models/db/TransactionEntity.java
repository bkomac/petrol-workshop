package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.enums.TransactionStatus;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions_xx")
public class TransactionEntity extends BaseEntity {

    @Column(name = "currency")
    private String currency;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "nonce")
    private String nonce;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;
    @Column(name = "gateway_decline_code")
    private String gatewayDeclineCode;
    @Column(name = "process_response_code")
    private String processorResponseCode;
    @Column(name = "process_response_text")
    private String processorResponseText;

    @Embedded
    private PaymentMethodInfoEntity paymentMethodInfo;

    @Column(name = "gateway_trans_id")
    private String gatewayTransactionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_address_id")
    private AddressEntity billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_address_id")
    private AddressEntity shippingAddress;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getGatewayDeclineCode() {
        return gatewayDeclineCode;
    }

    public void setGatewayDeclineCode(String gatewayDeclineCode) {
        this.gatewayDeclineCode = gatewayDeclineCode;
    }

    public String getProcessorResponseCode() {
        return processorResponseCode;
    }

    public void setProcessorResponseCode(String processorResponseCode) {
        this.processorResponseCode = processorResponseCode;
    }

    public String getProcessorResponseText() {
        return processorResponseText;
    }

    public void setProcessorResponseText(String processorResponseText) {
        this.processorResponseText = processorResponseText;
    }

    public PaymentMethodInfoEntity getPaymentMethodInfo() {
        return paymentMethodInfo;
    }

    public void setPaymentMethodInfo(PaymentMethodInfoEntity paymentMethodInfo) {
        this.paymentMethodInfo = paymentMethodInfo;
    }

    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    public void setGatewayTransactionId(String gatewayTransactionId) {
        this.gatewayTransactionId = gatewayTransactionId;
    }

    public AddressEntity getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressEntity billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AddressEntity getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressEntity shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
