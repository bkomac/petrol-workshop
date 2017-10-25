package si.petrol.workshop.market.services.beans;

public enum MarketErrorCode {


    CART_EXPIRED("cart.expired"),
    CART_ITEM_ALLREADY_IN_CART("cart.item.already.in.cart"),
    ORDER_INCORRECT_STATE("order.incorrect.state"),
    ORDER_CART_EMPTY("order.cart.empty"),
    UNKNOWN("unknown");

    private String code;

    MarketErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
