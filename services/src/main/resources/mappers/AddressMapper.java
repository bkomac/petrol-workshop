package mappers;

import si.petrol.workshop.market.lib.Address;
import si.petrol.workshop.market.models.db.AddressEntity;

public class AddressMapper {

    public static Address toAddress(AddressEntity entity) {

        if (entity == null) return null;

        Address address = new Address();
        address.setCity(entity.getCity());
        address.setCountry(entity.getCountry());
        address.setCountryAlpha2(entity.getCountryAlpha2());
        address.setCountryAlpha3(entity.getCountryAlpha3());
        address.setPostalCode(entity.getPostalCode());
        address.setStreetName(entity.getStreetName());
        address.setStreetNumber(entity.getStreetNumber());

        return address;
    }

    public static AddressEntity toAddressEntity(Address address) {

        if (address == null) return null;

        AddressEntity entity = new AddressEntity();
        entity.setCity(address.getCity());
        entity.setCountry(address.getCountry());
        entity.setCountryAlpha2(address.getCountryAlpha2());
        entity.setCountryAlpha3(address.getCountryAlpha3());
        entity.setPostalCode(address.getPostalCode());
        entity.setStreetName(address.getStreetName());
        entity.setStreetNumber(address.getStreetNumber());

        return entity;
    }
}
