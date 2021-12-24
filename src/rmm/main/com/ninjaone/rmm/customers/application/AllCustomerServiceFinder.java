package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.rmm.customers.domain.AllServiceByCustomerFinder;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@com.ninjaone.shared.domain.Service
public final class AllCustomerServiceFinder {
    private final AllServiceByCustomerFinder finder;

    public AllCustomerServiceFinder(CustomerServiceRepository repository, ServiceRepository serviceRepository,
                                    CustomerRepository customerRepository) {
        finder = new AllServiceByCustomerFinder(repository, serviceRepository, customerRepository);
    }

    public List<ServiceResponse> find(String id) {
        List<Service> services = finder.find(id);

        return services
            .stream()
            .map(ServiceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
