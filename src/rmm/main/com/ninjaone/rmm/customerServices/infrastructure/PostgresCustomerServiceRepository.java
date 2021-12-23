package com.ninjaone.rmm.customerServices.infrastructure;

import com.ninjaone.rmm.customerServices.domain.CustomerService;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostgresCustomerServiceRepository extends HibernateRepository<CustomerService> implements CustomerServiceRepository {
    public PostgresCustomerServiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, CustomerService.class);
    }

    @Override
    public void save(CustomerService customerService) {
        persist(customerService);
    }

    @Override
    public List<CustomerService> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
