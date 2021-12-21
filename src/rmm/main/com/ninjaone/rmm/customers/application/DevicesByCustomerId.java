package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class DevicesByCustomerId {
    private final DeviceRepository deviceRepository;
    private final CustomerFinder customerFinder;

    public DevicesByCustomerId(CustomerRepository repository, DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        customerFinder = new CustomerFinder(repository);
    }

    public List<CustomerDeviceResponse> find(String customerId) {
        CustomerId id = new CustomerId(customerId);
        Customer customer = customerFinder.find(id);

        Filter customerIdFilter = Filter.create("customerId", FilterOperator.EQUAL.value(), customer.id().value());
        Criteria customerIdCriteria = new Criteria(
            new Filters(Collections.singletonList(customerIdFilter)),
            Order.asc("id")
        );
        return this.deviceRepository.matching(customerIdCriteria)
            .stream()
            .map(CustomerDeviceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
