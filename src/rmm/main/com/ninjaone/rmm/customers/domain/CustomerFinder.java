package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.Service;

@Service
public class CustomerFinder {
    private final CustomerRepository repository;

    public CustomerFinder(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer find(CustomerId customerId) {
        return this.repository.search(customerId).orElseThrow(() -> new CustomerNotExist(customerId));
    }
}
