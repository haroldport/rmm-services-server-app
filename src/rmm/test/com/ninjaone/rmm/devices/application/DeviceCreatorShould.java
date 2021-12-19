package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class DeviceCreatorShould {
    @Test
    void save_a_valid_device() {
        DeviceRepository repository = mock(DeviceRepository.class);
        DeviceCreator creator = new DeviceCreator(repository);

        Device device = new Device("some-id", "Dell", "Windows Workstation");

        creator.create(new CreateDeviceRequest(device.id(), device.systemName(), device.type()));

        verify(repository, atLeastOnce()).save(device);
    }

}
