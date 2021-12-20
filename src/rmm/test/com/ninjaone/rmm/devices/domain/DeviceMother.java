package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.application.CreateDeviceRequest;

public class DeviceMother {
    public static Device create(DeviceId id, DeviceSystemName systemName, DeviceType type) {
        return new Device(id, systemName, type);
    }

    public static Device fromRequest(CreateDeviceRequest request) {
        return create(
            DeviceIdMother.create(request.id()),
            DeviceSystemNameMother.create(request.systemName()),
            DeviceTypeMother.create(request.type())
        );
    }

    public static Device random() {
        return create(
            DeviceIdMother.random(),
            DeviceSystemNameMother.random(),
            DeviceTypeMother.randomValidValues()
        );
    }
}
