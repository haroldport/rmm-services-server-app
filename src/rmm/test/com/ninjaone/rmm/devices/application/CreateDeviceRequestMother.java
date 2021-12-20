package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.*;

public final class CreateDeviceRequestMother {
    public static CreateDeviceRequest create(DeviceId id, DeviceSystemName systemName, DeviceType type) {
        return new CreateDeviceRequest(id.value(), systemName.value(), type.value());
    }

    public static CreateDeviceRequest randomWithValidDeviceType() {
        return create(DeviceIdMother.random(), DeviceSystemNameMother.random(), DeviceTypeMother.randomValidValues());
    }

    public static CreateDeviceRequest randomWithInvalidDeviceType() {
        return create(DeviceIdMother.random(), DeviceSystemNameMother.random(), DeviceTypeMother.randomInvalidValues());
    }
}
