package mappers;

import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.models.db.CustomerEntity;

public class CustomerMapper {

    public static Customer toCustomer(CustomerEntity customerEntity) {

        if (customerEntity == null) return null;

        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setUpdatedAt(customerEntity.getUpdatedAt());
        customer.setCreatedAt(customerEntity.getCreatedAt());

        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setEmail(customerEntity.getEmail());
        customer.setDateOfBirth(customerEntity.getDateOfBirth());
        customer.setStatus(customerEntity.getStatus());
        customer.setAddress(AddressMapper.toAddress(customerEntity.getAddress()));

        return customer;
    }

    public static CustomerEntity toCustomerEntity(Customer customer, CustomerEntity customerEntity) {

        if (customer == null || customerEntity == null) return null;

        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setDateOfBirth(customer.getDateOfBirth());
        customerEntity.setStatus(customer.getStatus());
        customerEntity.setAddress(AddressMapper.toAddressEntity(customer.getAddress()));

        return customerEntity;
    }
}
