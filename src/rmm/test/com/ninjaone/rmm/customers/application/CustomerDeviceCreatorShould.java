package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.CustomersModuleUnitTestCase;
import com.ninjaone.rmm.customers.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class CustomerDeviceCreatorShould extends CustomersModuleUnitTestCase {
    private CustomerDeviceCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        creator = new CustomerDeviceCreator(repository);
    }

    @Test
    void add_a_valid_device_to_customer() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));

        when(repository.search(customer.id())).thenReturn(Optional.of(customer));

        CreateCustomerDeviceRequest request = CreateCustomerDeviceRequestMother.randomWithValidDeviceType(customer.id());

        Device device = DeviceMother.fromRequest(request);

        customer.addOrUpdateDevice(device);

        creator.create(request);

        shouldHaveSaved(customer);
    }

    @Test
    void throw_an_device_type_invalid_error_when_add_a_device_to_customer_with_invalid_type() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));

        when(repository.search(customer.id())).thenReturn(Optional.of(customer));

        DeviceTypeInvalid thrown = assertThrows(DeviceTypeInvalid.class, () -> {
            CreateCustomerDeviceRequest request = CreateCustomerDeviceRequestMother.randomWithInvalidDeviceType();

            Device device = DeviceMother.fromRequest(request);

            customer.addOrUpdateDevice(device);

            creator.create(request);
        });

        assertEquals("device_type_invalid", thrown.errorCode());
    }

    @Test
    void throw_an_customer_not_exist_error_when_add_a_device_to_non_existint_customer() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));

        CustomerNotExist thrown = assertThrows(CustomerNotExist.class, () -> {
            CreateCustomerDeviceRequest request = CreateCustomerDeviceRequestMother.randomWithValidDeviceType(customer.id());

            Device device = DeviceMother.fromRequest(request);

            customer.addOrUpdateDevice(device);

            creator.create(request);
        });

        assertEquals("customer_not_exist", thrown.errorCode());
    }

}
