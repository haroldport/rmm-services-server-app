package com.ninjaone.rmm.services.infrastructure;

import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@com.ninjaone.shared.domain.Service
@Transactional
public class PostgresServiceRepository extends HibernateRepository<Service> implements ServiceRepository {
    public PostgresServiceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Service.class);
    }

    @Override
    public void save(Service service) {
        persist(service);
    }

    @Override
    public List<Service> searchAll() {
        return all();
    }
}

