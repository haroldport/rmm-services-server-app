package com.ninjaone.rmm.customerServices.infrastructure;

import com.ninjaone.rmm.customerServices.domain.CustomerService;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class CustomerServicesModuleUnitTestCase extends UnitTestCase {
    protected CustomerServiceRepository repository;
    protected CustomerRepository customerRepository;
    protected ServiceRepository serviceRepository;

    @BeforeEach
    protected void setUp() {
        repository = mock(CustomerServiceRepository.class);
        customerRepository = mock(CustomerRepository.class);
        serviceRepository = mock(ServiceRepository.class);
    }

    public void shouldHaveSaved(CustomerService customerService) {
        verify(repository, atLeastOnce()).save(customerService);
    }
}
