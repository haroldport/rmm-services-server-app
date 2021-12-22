package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceUpdater {
    private final DeviceRepository repository;
    private final DeviceFinder finder;

    public DeviceUpdater(DeviceRepository repository) {
        this.repository = repository;
        finder = new DeviceFinder(repository);
    }

    public void update(DeviceUpdaterRequest request) {
        DeviceId id = new DeviceId(request.id());
        Device device = this.finder.find(id);

        DeviceSystemName systemName = new DeviceSystemName(request.systemName().orElse(device.systemName().value()));
        DeviceType type = new DeviceType(request.type().orElse(device.type().value()));


        this.repository.save(new Device(device.id(), systemName, type, device.customerId()));
    }
}
