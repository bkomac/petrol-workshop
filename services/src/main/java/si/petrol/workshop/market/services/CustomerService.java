package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(String id);

    List<Customer> findCustomers();

    Long findCustomersCount();

    Customer createCustomer(Customer customer);


}
