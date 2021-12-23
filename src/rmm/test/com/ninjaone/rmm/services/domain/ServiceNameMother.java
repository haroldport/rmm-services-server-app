package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.MotherCreator;

public final class ServiceNameMother {
    public static ServiceName create(String value) {
        return new ServiceName(value);
    }

    public static ServiceName random() {
        return create(MotherCreator.random().dragonBall().character());
    }
}
