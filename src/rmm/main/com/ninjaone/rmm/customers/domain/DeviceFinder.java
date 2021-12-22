package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.Service;

@Service
public class DeviceFinder {
    private final DeviceRepository repository;

    public DeviceFinder(DeviceRepository repository) {
        this.repository = repository;
    }

    public Device find(DeviceId deviceId) {
        return this.repository.search(deviceId).orElseThrow(() -> new DeviceNotExist(deviceId));
    }
}
