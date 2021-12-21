package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.UuidMother;

public final class CustomerIdMother {
    public static CustomerId create(String value) {
        return new CustomerId(value);
    }

    public static CustomerId random() {
        return create(UuidMother.random());
    }
}
