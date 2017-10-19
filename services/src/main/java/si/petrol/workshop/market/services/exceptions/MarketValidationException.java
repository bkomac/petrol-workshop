package si.petrol.workshop.market.services.exceptions;

import si.petrol.workshop.market.lib.common.ValidationError;

import java.util.List;

/**
 * Payment validation exception
 *
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class MarketValidationException extends RuntimeException {

    private List<ValidationError> errors;

    public MarketValidationException(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
