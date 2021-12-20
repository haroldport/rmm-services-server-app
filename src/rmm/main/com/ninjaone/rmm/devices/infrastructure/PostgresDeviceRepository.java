package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceId;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.shared.domain.Service;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PostgresDeviceRepository implements DeviceRepository {
    private final SessionFactory sessionFactory;

    public PostgresDeviceRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Device device) {
        sessionFactory.getCurrentSession().save(device);
    }

    @Override
    public Optional<Device> search(DeviceId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Device.class, id));
    }
}
