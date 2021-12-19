package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public final class DeviceCreator {
    private final DeviceRepository repository;

    public DeviceCreator(DeviceRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String systemName, String type) {
        Device device = new Device(id, systemName, type);

        this.repository.save(device);
    }
}
