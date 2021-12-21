package com.ninjaone.rmm.customers.domain;

import java.util.Objects;

public class CustomerPassword {
    private static final int MIN_LENGTH = 8;

    private String value;

    public CustomerPassword(String value) {
        this.ensureIsValidPassword(value);
        this.value = value;
    }

    public CustomerPassword() {
    }

    public String value() {
        return value;
    }

    private void ensureIsValidPassword(String value) {
        if (value.length() < MIN_LENGTH) {
            throw new CustomerPasswordInvalid(value);
        }
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerPassword)) {
            return false;
        }
        CustomerPassword that = (CustomerPassword) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
