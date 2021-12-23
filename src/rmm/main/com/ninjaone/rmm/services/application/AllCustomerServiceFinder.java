package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.customerServices.domain.CustomerService;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.rmm.customers.domain.CustomerFinder;
import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AllCustomerServiceFinder {
    private final CustomerServiceRepository repository;
    private final ServiceRepository serviceRepository;
    private final CustomerFinder customerFinder;

    public AllCustomerServiceFinder(CustomerServiceRepository repository, ServiceRepository serviceRepository,
                                    CustomerRepository customerRepository) {
        this.repository = repository;
        this.serviceRepository = serviceRepository;
        customerFinder = new CustomerFinder(customerRepository);
    }

    public List<ServiceResponse> find(String id) {
        CustomerId customerId = new CustomerId(id);
        customerFinder.find(customerId);
        Filter customerFilter = Filter.create("customerId", FilterOperator.EQUAL.value(), customerId.value());
        Criteria customerServiceCriteria = new Criteria(
            new Filters(Collections.singletonList(customerFilter)),
            Order.asc("id")
        );
        List<CustomerService> customerServices = repository.matching(customerServiceCriteria);
        if (customerServices.size() == 0) {
            return Collections.emptyList();
        }
        Filters filters = new Filters(Collections.singletonList(
            Filter.create(
                "id",
                FilterOperator.IN.value(),
                customerServices.stream().map(cs -> cs.serviceId().value()).collect(Collectors.toList())
            )
        ));

        return this.serviceRepository.matching(new Criteria(filters, Order.asc("id")))
            .stream()
            .map(ServiceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
