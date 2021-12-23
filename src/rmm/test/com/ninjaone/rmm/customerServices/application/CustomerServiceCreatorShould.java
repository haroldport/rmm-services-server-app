package com.ninjaone.rmm.customerServices.application;

import com.ninjaone.rmm.customerServices.domain.CustomerService;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceId;
import com.ninjaone.rmm.customerServices.infrastructure.CustomerServicesModuleUnitTestCase;
import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.ServiceNotExist;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

final class CustomerServiceCreatorShould extends CustomerServicesModuleUnitTestCase {
    private CustomerServiceCreator creator;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        creator = new CustomerServiceCreator(repository, customerRepository, serviceRepository);
    }

    @Test
    void add_a_existed_service_to_customer() {
        Customer customer = CustomerMother.random();
        Service service = ServiceMother.random();

        when(customerRepository.search(customer.id())).thenReturn(Optional.of(customer));
        when(serviceRepository.search(service.id())).thenReturn(Optional.of(service));

        CreateCustomerServiceRequest request = new CreateCustomerServiceRequest(
            UuidMother.random(), customer.id().value(), service.id().value()
        );

        CustomerService customerService = new CustomerService(
            new CustomerServiceId(request.id()), customer.id(), service.id()
        );

        creator.create(request);

        shouldHaveSaved(customerService);
    }

    @Test
    void throw_a_customer_not_exist_error_when_add_a_service_to_non_existint_customer() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));
        Service service = ServiceMother.random();
        when(serviceRepository.search(service.id())).thenReturn(Optional.of(service));

        CustomerNotExist thrown = assertThrows(CustomerNotExist.class, () -> {
            CreateCustomerServiceRequest request = new CreateCustomerServiceRequest(
                UuidMother.random(), customer.id().value(), service.id().value()
            );

            creator.create(request);
        });

        assertEquals("customer_not_exist", thrown.errorCode());
    }

    @Test
    void throw_a_service_not_exist_error_when_add_a_non_existing_service_to_existint_customer() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));
        Service service = ServiceMother.random();
        when(customerRepository.search(customer.id())).thenReturn(Optional.of(customer));

        ServiceNotExist thrown = assertThrows(ServiceNotExist.class, () -> {
            CreateCustomerServiceRequest request = new CreateCustomerServiceRequest(
                UuidMother.random(), customer.id().value(), service.id().value()
            );

            creator.create(request);
        });

        assertEquals("service_not_exist", thrown.errorCode());
    }

}
