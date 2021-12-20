package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceId;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
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
    public Optional<Device> search(DeviceId id) {
        return byId(id);
    }
}
