package com.ninjaone.rmm.devices.infrastructure.persistence;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryDeviceRepository implements DeviceRepository {
    private final HashMap<String, Device> devices = new HashMap<>();

    @Override
    public void save(Device device) {
        this.devices.put(device.id(), device);
    }

    @Override
    public Optional<Device> search(String id) {
        return Optional.ofNullable(devices.get(id));
    }
}
