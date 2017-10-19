package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.mappers.CustomerMapper;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.services.CustomerService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer findCustomerById(String id) {
        CustomerEntity custEnt = em.find(CustomerEntity.class, id);

        return CustomerMapper.toCustomer(custEnt);
    }

    @Override
    public List<Customer> findCustomers() {
        return null;
    }


    @Override
    public Long findCustomersCount() {
        return null;
    }

    @Override
    public Customer createCustomer(Customer customer) {

        CustomerEntity custEnt = CustomerMapper.toCustomerEntity(customer, new CustomerEntity());

        em.getTransaction().begin();
        em.persist(custEnt);
        em.getTransaction().commit();

        return CustomerMapper.toCustomer(custEnt);
    }
}
