package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.*;
import org.springframework.stereotype.Service;

@Service
public final class DeviceCreator {
    private final DeviceRepository repository;

    public DeviceCreator(DeviceRepository repository) {
        this.repository = repository;
    }

    public void create(CreateDeviceRequest request) {
        DeviceId id = new DeviceId(request.id());
        DeviceSystemName systemName = new DeviceSystemName(request.systemName());
        DeviceType type = new DeviceType(request.type());

        Device device = new Device(id, systemName, type);

        this.repository.save(device);
    }
}
