package com.ninjaone.rmm.customers.domain;

public final class CustomerPasswordMother {
    public static CustomerPassword create(String value) {
        return new CustomerPassword(value);
    }

    public static CustomerPassword random() {
        return create("Test1234");
    }

    public static CustomerPassword fail() {
        return create("some");
    }
}
