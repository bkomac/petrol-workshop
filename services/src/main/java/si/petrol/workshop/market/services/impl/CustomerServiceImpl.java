package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.lib.responses.CountWrapper;
import si.petrol.workshop.market.mappers.CustomerMapper;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.services.CustomerService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

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

        TypedQuery<CustomerEntity> q1 = em.createNamedQuery("CustomerEntitiy.findAll", CustomerEntity.class);

        List<CustomerEntity> custEntities = q1.getResultList();

        return custEntities.stream()
                .map(CustomerMapper::toCustomer)
                .collect(Collectors.toList());
    }


    @Override
    public CountWrapper findCustomersCount() {
        TypedQuery<Long> q1 = em.createNamedQuery("CustomerEntitiy.findAllCount", Long.class);
        Long count = q1.getSingleResult();

        CountWrapper countWrap = new CountWrapper();
        countWrap.setCount(count);

        return countWrap;
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
