package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class DeviceCreatorShould {
    @Test
    void save_a_valid_device() {
        DeviceRepository repository = mock(DeviceRepository.class);
        DeviceCreator creator = new DeviceCreator(repository);

        CreateDeviceRequest request = CreateDeviceRequestMother.random();

        Device device = DeviceMother.fromRequest(request);

        creator.create(request);

        verify(repository, atLeastOnce()).save(device);
    }

}
