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

    public void create(CreateDeviceRequest request) {
        Device device = new Device(request.id(), request.systemName(), request.type());

        this.repository.save(device);
    }
}
