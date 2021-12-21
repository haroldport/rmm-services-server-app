package com.ninjaone.rmm.customers.infrastructure;

import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostgresCustomerRepository extends HibernateRepository<Customer> implements CustomerRepository {
    public PostgresCustomerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }

    @Override
    public void save(Customer customer) {
        persist(customer);
    }

    @Override
    public Optional<Customer> search(CustomerId id) {
        return byId(id);
    }

    @Override
    public List<Customer> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
