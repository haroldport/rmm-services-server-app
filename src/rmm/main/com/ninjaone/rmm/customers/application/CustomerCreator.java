package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.*;

import java.util.Collections;
import java.util.List;

@Service
public final class CustomerCreator {
    private final CustomerRepository repository;

    public CustomerCreator(CustomerRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCustomerRequest request) {
        CustomerId id = new CustomerId(request.id());
        CustomerUserName username = new CustomerUserName(request.username());
        CustomerPassword password = new CustomerPassword(request.password());

        ensureCustomerWhenUsernameNotExists(username);

        Customer customer = new Customer(id, username, password);

        this.repository.save(customer);
    }

    private void ensureCustomerWhenUsernameNotExists(CustomerUserName username) {
        Filter usernameFilter = Filter.create("username", FilterOperator.EQUAL.value(), username.value());
        Criteria usernameCriteria = new Criteria(
            new Filters(Collections.singletonList(usernameFilter)),
            Order.asc("username")
        );
        List<Customer> customers = this.repository.matching(usernameCriteria);
        if (customers.size() > 0) {
            throw new CustomerAlreadyExists(username.value());
        }
    }
}
