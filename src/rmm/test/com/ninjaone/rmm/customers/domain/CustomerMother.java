package com.ninjaone.rmm.customers.domain;

import com.ninjaone.rmm.customers.application.CreateCustomerRequest;

public class CustomerMother {
    public static Customer create(CustomerId id, CustomerUserName username, CustomerPassword password) {
        return new Customer(id, username, password);
    }

    public static Customer fromRequest(CreateCustomerRequest request) {
        return create(
            CustomerIdMother.create(request.id()),
            CustomerUserNameMother.create(request.username()),
            CustomerPasswordMother.create(request.password())
        );
    }

    public static Customer random() {
        return create(
            CustomerIdMother.random(),
            CustomerUserNameMother.random(),
            CustomerPasswordMother.random()
        );
    }
}
