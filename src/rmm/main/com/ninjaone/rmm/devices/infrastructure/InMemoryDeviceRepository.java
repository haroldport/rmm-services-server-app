package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceId;
import com.ninjaone.rmm.devices.domain.DeviceRepository;

import java.util.HashMap;
import java.util.Optional;

public final class InMemoryDeviceRepository implements DeviceRepository {
    private final HashMap<String, Device> devices = new HashMap<>();

    @Override
    public void save(Device device) {
        this.devices.put(device.id().value(), device);
    }

    @Override
    public Optional<Device> search(DeviceId id) {
        return Optional.ofNullable(devices.get(id.value()));
    }
}
