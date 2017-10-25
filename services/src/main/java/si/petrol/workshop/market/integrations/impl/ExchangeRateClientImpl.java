package si.petrol.workshop.market.integrations.impl;

import si.petrol.workshop.market.integrations.ExchangeRatesClient;
import si.petrol.workshop.market.integrations.beans.Rate;
import si.petrol.workshop.market.services.beans.MarketErrorCode;
import si.petrol.workshop.market.services.exceptions.GeneralServiceException;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.providers.JacksonProvider;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ExchangeRateClientImpl implements ExchangeRatesClient {


    private Client client;

    @PostConstruct
    private void init() {
        client = ClientBuilder.newClient().register(JacksonProvider.class);
    }

    @Override
    public Rate findRateByCurrency(String currency) {
        try {
            return client.target("http://api.fixer.io/latest")
                    .queryParam("base", currency)
                    .queryParam("symbols", "EUR")
                    .request(MediaType.APPLICATION_JSON_TYPE).get(Rate.class);

        } catch (WebApplicationException e) {
            switch (e.getResponse().getStatus()) {

                case 422:
                    throw new MarketException(MarketErrorCode.CURRENCY_INVALID);

            }
            throw new GeneralServiceException(e);

        }
    }
}