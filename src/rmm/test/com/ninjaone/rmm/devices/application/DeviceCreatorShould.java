package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.Device;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.DeviceTypeInvalid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class DeviceCreatorShould extends DevicesModuleUnitTestCase {
    private DeviceCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        creator = new DeviceCreator(repository);
    }

    @Test
    void save_a_valid_device() {
        CreateDeviceRequest request = CreateDeviceRequestMother.randomWithValidDeviceType();

        Device device = DeviceMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(device);
    }

    @Test
    void throw_an_error_when_save_a_device_with_invalid_type() {
        DeviceTypeInvalid thrown = assertThrows(DeviceTypeInvalid.class, () -> {
            CreateDeviceRequest request = CreateDeviceRequestMother.randomWithInvalidDeviceType();
            creator.create(request);
        });

        assertEquals("device_type_invalid", thrown.errorCode());
    }

}
