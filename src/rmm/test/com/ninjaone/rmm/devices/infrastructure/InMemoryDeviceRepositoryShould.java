package com.ninjaone.rmm.devices.infrastructure;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.infrastructure.persistence.InMemoryDeviceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

final class InMemoryDeviceRepositoryShould {
    @Test
    void save_a_valid_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        repository.save(new Device("some-id", "some-system-name", "some-type"));
    }

    @Test
    void search_an_existing_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        Device device = new Device("some-id", "some-system-name", "some-type");

        repository.save(device);

        Assertions.assertEquals(Optional.of(device), repository.search(device.id()));
    }

    @Test
    void not_find_a_non_existing_device() {
        InMemoryDeviceRepository repository = new InMemoryDeviceRepository();

        Assertions.assertFalse(repository.search("non-existing-id").isPresent());
    }
}
