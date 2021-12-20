package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.DevicesModuleInfrastructureTestCase;
import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceIdMother;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryDeviceRepositoryShould extends DevicesModuleInfrastructureTestCase {
    @Test
    void save_a_valid_device() {
        Device device = DeviceMother.random();

        inMemoryDeviceRepository.save(device);
    }

    @Test
    void search_an_existing_device() {
        Device device = DeviceMother.random();

        inMemoryDeviceRepository.save(device);

        assertEquals(Optional.of(device), inMemoryDeviceRepository.search(device.id()));
    }

    @Test
    void not_find_a_non_existing_device() {
        assertFalse(inMemoryDeviceRepository.search(DeviceIdMother.random()).isPresent());
    }
}
