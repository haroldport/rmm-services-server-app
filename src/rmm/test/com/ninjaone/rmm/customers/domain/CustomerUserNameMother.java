package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.MotherCreator;

public final class CustomerUserNameMother {
    public static CustomerUserName create(String value) {
        return new CustomerUserName(value);
    }

    public static CustomerUserName random() {
        return create(MotherCreator.random().funnyName().name());
    }
}
