package com.ninjaone.rmm.customerServices.domain;

import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.services.domain.ServiceId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceFinder {
    private final CustomerServiceRepository repository;

    public CustomerServiceFinder(CustomerServiceRepository repository) {
        this.repository = repository;
    }

    public Optional<CustomerService> find(CustomerId customerId, ServiceId serviceId) {
        Filter customerFilter = Filter.create("customerId", FilterOperator.EQUAL.value(), customerId.value());
        Filter serviceFilter = Filter.create("serviceId", FilterOperator.EQUAL.value(), serviceId.value());
        Criteria customerServiceCriteria = new Criteria(
            new Filters(Arrays.asList(customerFilter, serviceFilter)),
            Order.asc("id")
        );
        List<CustomerService> customerServices = this.repository.matching(customerServiceCriteria);
        if (customerServices.size() > 0) {
            return Optional.of(customerServices.get(0));
        }
        return Optional.empty();
    }
}
