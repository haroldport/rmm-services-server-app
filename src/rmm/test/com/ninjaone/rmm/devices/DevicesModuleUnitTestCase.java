package com.ninjaone.rmm.devices;

import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class DevicesModuleUnitTestCase extends UnitTestCase {
    protected DeviceRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(DeviceRepository.class);
    }

    public void shouldHaveSaved(Device device) {
        verify(repository, atLeastOnce()).save(device);
    }
}
