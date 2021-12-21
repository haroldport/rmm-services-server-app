package com.ninjaone.rmm.customers;


import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomersModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected CustomerRepository repository;
}
