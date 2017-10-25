
package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.enums.CreditCardType;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PaymentMethodInfoEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_card_type")
    private CreditCardType creditCardType;

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
