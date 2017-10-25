package si.petrol.workshop.market.services.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


public class ConfigProducer {

    @Produces
    @ApplicationScoped
    public ServiceProperties getServiceProperties() {

        ServiceProperties prop = new ServiceProperties();

        String exchangeUrl = System.getenv("EXCHANGE_URL");


        if (exchangeUrl != null)
            prop.setExchangeUrl(exchangeUrl);

        return prop;
    }

}
