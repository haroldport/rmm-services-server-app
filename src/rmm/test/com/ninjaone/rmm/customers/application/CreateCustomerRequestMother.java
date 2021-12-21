package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;

public final class CreateCustomerRequestMother {
    public static CreateCustomerRequest create(CustomerId id, CustomerUserName username, CustomerPassword password) {
        return new CreateCustomerRequest(id.value(), username.value(), password.value());
    }

    public static CreateCustomerRequest random() {
        return create(CustomerIdMother.random(), CustomerUserNameMother.random(), CustomerPasswordMother.random());
    }

    public static CreateCustomerRequest fail() {
        return create(CustomerIdMother.random(), CustomerUserNameMother.random(), CustomerPasswordMother.fail());
    }
}
