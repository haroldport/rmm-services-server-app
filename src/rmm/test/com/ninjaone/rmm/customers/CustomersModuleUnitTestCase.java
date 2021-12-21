package com.ninjaone.rmm.customers;

import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class CustomersModuleUnitTestCase extends UnitTestCase {
    protected CustomerRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(CustomerRepository.class);
    }

    public void shouldHaveSaved(Customer customer) {
        verify(repository, atLeastOnce()).save(customer);
    }
}
