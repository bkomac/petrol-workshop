package si.petrol.workshop.market.integrations;

import si.petrol.workshop.market.integrations.beans.Rate;

public interface ExchangeRatesClient {

    Rate findRateByCurrency(String currency);

}
