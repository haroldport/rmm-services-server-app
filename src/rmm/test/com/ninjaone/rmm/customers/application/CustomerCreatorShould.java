package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.CustomersModuleUnitTestCase;
import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerMother;
import com.ninjaone.rmm.customers.domain.CustomerPasswordInvalid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CustomerCreatorShould extends CustomersModuleUnitTestCase {
    private CustomerCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        creator = new CustomerCreator(repository);
    }

    @Test
    void save_a_valid_customer() {
        CreateCustomerRequest request = CreateCustomerRequestMother.random();

        Customer customer = CustomerMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(customer);
    }

    @Test
    void throw_an_error_when_save_a_customer_with_invalid_password() {
        CustomerPasswordInvalid thrown = assertThrows(CustomerPasswordInvalid.class, () -> {
            CreateCustomerRequest request = CreateCustomerRequestMother.fail();
            creator.create(request);
        });

        assertEquals("customer_password_invalid", thrown.errorCode());
    }

}
