package com.ninjaone.rmm.customers.infrastructure;

import com.ninjaone.rmm.customers.CustomersModuleInfrastructureTestCase;
import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerIdMother;
import com.ninjaone.rmm.customers.domain.CustomerMother;
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
}
