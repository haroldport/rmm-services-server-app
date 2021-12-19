package com.ninjaone.rmm.devices.domain;

import java.util.Optional;

public interface DeviceRepository {
    void save(Device device);

    Optional<Device> search(String id);
}
