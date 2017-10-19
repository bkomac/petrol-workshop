package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.lib.enums.PaymentMethodType;
import si.petrol.workshop.market.lib.enums.TransactionStatus;

import java.math.BigDecimal;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Transaction extends BaseType {

    private String currency;
    private BigDecimal amount;
    private String nonce;
    private TransactionStatus status;
    private String gatewayDeclineCode;
    private String processorResponseCode;
    private String processorResponseText;
    private PaymentMethodType paymentMethodType;
    private PaymentMethodInfo paymentMethodInfo;
    private String gatewayTransactionId;
    private Address billingAddress;
    private Address shippingAddress;

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

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public PaymentMethodInfo getPaymentMethodInfo() {
        return paymentMethodInfo;
    }

    public void setPaymentMethodInfo(PaymentMethodInfo paymentMethodInfo) {
        this.paymentMethodInfo = paymentMethodInfo;
    }

    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    public void setGatewayTransactionId(String gatewayTransactionId) {
        this.gatewayTransactionId = gatewayTransactionId;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
