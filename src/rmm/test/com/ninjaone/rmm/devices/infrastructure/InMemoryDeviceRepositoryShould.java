package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceIdMother;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryDeviceRepositoryShould {
    @Test
    void save_a_valid_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        Device device = DeviceMother.random();

        repository.save(device);
    }

    @Test
    void search_an_existing_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        Device device = DeviceMother.random();

        repository.save(device);

        assertEquals(Optional.of(device), repository.search(device.id()));
    }

    @Test
    void not_find_a_non_existing_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        assertFalse(repository.search(DeviceIdMother.random()).isPresent());
    }
}
