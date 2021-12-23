package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class ServiceIdMother {
    public static ServiceId create(String value) {
        return new ServiceId(value);
    }

    public static ServiceId random() {
        return create(UuidMother.random());
    }
}
