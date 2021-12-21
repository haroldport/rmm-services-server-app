package com.ninjaone.rmm.customers.infrastructure;

import com.ninjaone.rmm.customers.domain.*;
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
    private final DeviceRepository deviceRepository;

    public PostgresCustomerRepository(SessionFactory sessionFactory, DeviceRepository deviceRepository) {
        super(sessionFactory, Customer.class);
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void save(Customer customer) {
        persist(customer);
        if (customer.hasDevices()) {
            Device device = customer.devices().iterator().next();
            this.deviceRepository.save(device);
        }
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
