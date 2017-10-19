package si.petrol.workshop.market.lib.requests;

import si.petrol.workshop.market.lib.Address;

public class CompleteOrderRequest {

    private String nonce;
    private Address billingAddress;
    private Address shippingAddress;

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
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
