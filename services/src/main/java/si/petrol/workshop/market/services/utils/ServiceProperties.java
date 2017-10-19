package si.petrol.workshop.market.services.utils;

public class ServiceProperties {

    private String headerTotalCountName = "X-Total-Count";
    private String baseUrl = "http://localhost:8080/v1";

    public String getHeaderTotalCountName() {
        return headerTotalCountName;
    }

    public void setHeaderTotalCountName(String headerTotalCountName) {
        this.headerTotalCountName = headerTotalCountName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
