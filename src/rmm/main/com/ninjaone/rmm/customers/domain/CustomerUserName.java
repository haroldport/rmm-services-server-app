package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.StringValueObject;

public final class CustomerUserName extends StringValueObject {
    public CustomerUserName(String value) {
        super(value);
    }

    public CustomerUserName() {
        super("");
    }
}
