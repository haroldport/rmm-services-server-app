package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceDeleter {
    private final DeviceRepository repository;
    private final DeviceFinder finder;

    public DeviceDeleter(DeviceRepository repository) {
        this.repository = repository;
        finder = new DeviceFinder(repository);
    }

    public void delete(String deviceId) {
        DeviceId id = new DeviceId(deviceId);

        Device device = this.finder.find(id);

        this.repository.delete(device);
    }
}
