package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.DomainError;

public class CustomerPasswordInvalid extends DomainError {
    public CustomerPasswordInvalid(String password) {
        super(
            "customer_password_invalid",
            String.format("Password <%s> doesn't meet criteria [8 chars min].", password)
        );
    }
}
