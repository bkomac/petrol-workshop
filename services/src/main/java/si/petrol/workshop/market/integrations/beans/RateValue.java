package si.petrol.workshop.market.integrations.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RateValue {

    @JsonProperty("EUR")
    private BigDecimal eur;

    public BigDecimal getEur() {
        return eur;
    }

    public void setEur(BigDecimal eur) {
        this.eur = eur;
    }
}
