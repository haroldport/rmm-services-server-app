package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class DeviceIdMother {
    public static DeviceId create(String value) {
        return new DeviceId(value);
    }

    public static DeviceId random() {
        return create(UuidMother.random());
    }
}
