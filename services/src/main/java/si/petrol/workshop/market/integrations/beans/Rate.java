package si.petrol.workshop.market.integrations.beans;

import java.time.LocalDate;
import java.util.List;

public class Rate {

    private String base;
    private LocalDate date;
    private RateValue rates;


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RateValue getRates() {
        return rates;
    }

    public void setRates(RateValue rates) {
        this.rates = rates;
    }
}
