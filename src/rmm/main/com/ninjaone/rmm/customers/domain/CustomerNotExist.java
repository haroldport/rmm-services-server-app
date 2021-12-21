package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.DomainError;

public class CustomerNotExist extends DomainError {
    public CustomerNotExist(CustomerId customerId) {
        super(
            "customer_not_exist",
            String.format("The customer <%s> doesn't exist.", customerId.value())
        );
    }
}
