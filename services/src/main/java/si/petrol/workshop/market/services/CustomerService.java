package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.lib.responses.CountWrapper;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(String id);

    List<Customer> findCustomers();

    CountWrapper findCustomersCount();

    Customer createCustomer(Customer customer);


}
