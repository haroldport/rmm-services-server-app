package com.ninjaone.rmm.devices.domain;

public final class DeviceTypeMother {
    public static DeviceType create(String value) {
        return new DeviceType(value);
    }

    public static DeviceType random() {
        return create(com.ninjaone.shared.domain.WordMother.random());
    }
}
