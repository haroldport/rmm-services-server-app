package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.DomainError;

public class CustomerAlreadyExists extends DomainError {
    public CustomerAlreadyExists(String username) {
        super(
            "customer_already_exists",
            String.format("Customer with username %s already exists.", username)
        );
    }
}
