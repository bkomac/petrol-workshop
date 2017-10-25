package si.petrol.workshop.market.services.utils;

public class ServiceProperties {

    private String headerTotalCountName = "X-Total-Count";
    private String baseUrl = "http://localhost:8080/v1";

    private String exchangeUrl = "http://api.fixer.io/latest";
    private Boolean porcessorMock = true;

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

    public String getExchangeUrl() {
        return exchangeUrl;
    }

    public void setExchangeUrl(String exchangeUrl) {
        this.exchangeUrl = exchangeUrl;
    }

    public Boolean getPorcessorMock() {
        return porcessorMock;
    }

    public void setPorcessorMock(Boolean porcessorMock) {
        this.porcessorMock = porcessorMock;
    }
}
