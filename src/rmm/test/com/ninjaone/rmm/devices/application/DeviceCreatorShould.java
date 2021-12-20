package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class DeviceCreatorShould extends DevicesModuleUnitTestCase {
    private DeviceCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        creator = new DeviceCreator(repository);
    }

    @Test
    void save_a_valid_device() {
        CreateDeviceRequest request = CreateDeviceRequestMother.random();

        Device device = DeviceMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(device);
    }

}
