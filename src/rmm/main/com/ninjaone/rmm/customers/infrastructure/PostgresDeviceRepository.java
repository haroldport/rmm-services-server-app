package com.ninjaone.rmm.customers.infrastructure;

import com.ninjaone.rmm.customers.domain.Device;
import com.ninjaone.rmm.customers.domain.DeviceId;
import com.ninjaone.rmm.customers.domain.DeviceRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.Criteria;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostgresDeviceRepository extends HibernateRepository<Device> implements DeviceRepository {
    public PostgresDeviceRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Device.class);
    }

    @Override
    public void save(Device device) {
        persist(device);
    }

    @Override
    public void delete(Device device) {
        remove(device);
    }

    @Override
    public Optional<Device> search(DeviceId id) {
        return byId(id);
    }

    @Override
    public List<Device> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
