package si.petrol.workshop.market.services.exceptions;

import si.petrol.workshop.market.services.beans.MarketErrorCode;

public class MarketException extends Exception {

    private MarketErrorCode errorCode;

    public MarketException(MarketErrorCode code) {
        this.errorCode = code;
    }

    public MarketErrorCode getErrorCode() {
        return errorCode;
    }

}
