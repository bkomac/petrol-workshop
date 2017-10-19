package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Address extends BaseType {

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String country;
    private String countryAlpha2;
    private String countryAlpha3;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAlpha2() {
        return countryAlpha2;
    }

    public void setCountryAlpha2(String countryAlpha2) {
        this.countryAlpha2 = countryAlpha2;
    }

    public String getCountryAlpha3() {
        return countryAlpha3;
    }

    public void setCountryAlpha3(String countryAlpha3) {
        this.countryAlpha3 = countryAlpha3;
    }
}
