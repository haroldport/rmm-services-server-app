package com.ninjaone.rmm.customers.infrastructure;

import com.ninjaone.rmm.customers.CustomersModuleInfrastructureTestCase;
import com.ninjaone.rmm.customers.domain.*;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class PostgresCustomerRepositoryShould extends CustomersModuleInfrastructureTestCase {
    @Test
    void save_a_valid_customer() {
        Customer customer = CustomerMother.random();

        repository.save(customer);
    }

    @Test
    void search_an_existing_customer() {
        Customer customer = CustomerMother.random();

        repository.save(customer);

        assertEquals(Optional.of(customer), repository.search(customer.id()));
    }

    @Test
    void not_find_a_non_existing_customer() {
        assertFalse(repository.search(CustomerIdMother.random()).isPresent());
    }

    @Test
    void add_valid_device_an_existing_customer() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), CustomerUserNameMother.random(), new CustomerPassword("Test1234"));
        Device device = DeviceMother.random(customer.id());

        customer.addOrUpdateDevice(device);

        repository.save(customer);
    }
}
