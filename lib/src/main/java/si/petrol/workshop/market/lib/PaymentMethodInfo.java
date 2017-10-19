
package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.enums.CreditCardType;

/**
 * @author Tilen Faganel.
 * @since 1.0.0
 */
public class PaymentMethodInfo {

    private CreditCardType creditCardType;

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
