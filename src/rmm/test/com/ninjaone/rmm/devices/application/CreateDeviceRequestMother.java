package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.*;

public final class CreateDeviceRequestMother {
    public static CreateDeviceRequest create(DeviceId id, DeviceSystemName systemName, DeviceType type) {
        return new CreateDeviceRequest(id.value(), systemName.value(), type.value());
    }

    public static CreateDeviceRequest random() {
        return create(DeviceIdMother.random(), DeviceSystemNameMother.random(), DeviceTypeMother.random());
    }
}
