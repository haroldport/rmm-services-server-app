package com.ninjaone.rmm.devices.domain;

public final class DeviceSystemNameMother {
    public static DeviceSystemName create(String value) {
        return new DeviceSystemName(value);
    }

    public static DeviceSystemName random() {
        return create(com.ninjaone.shared.domain.WordMother.random());
    }
}
