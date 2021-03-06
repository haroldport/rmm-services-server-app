package com.ninjaone.rmm.customerServices.application;

import com.ninjaone.rmm.customerServices.domain.*;
import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerFinder;
import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceFinder;
import com.ninjaone.rmm.services.domain.ServiceId;
import com.ninjaone.rmm.services.domain.ServiceRepository;

import java.util.Optional;

@com.ninjaone.shared.domain.Service
public final class CustomerServiceCreator {
    private final CustomerServiceRepository repository;
    private final CustomerFinder customerFinder;
    private final ServiceFinder serviceFinder;
    private final CustomerServiceFinder customerServiceFinder;

    public CustomerServiceCreator(CustomerServiceRepository repository, CustomerRepository customerRepository,
                                  ServiceRepository serviceRepository) {
        this.repository = repository;
        customerFinder = new CustomerFinder(customerRepository);
        serviceFinder = new ServiceFinder(serviceRepository);
        customerServiceFinder = new CustomerServiceFinder(repository);
    }

    public void create(CreateCustomerServiceRequest request) {
        CustomerServiceId id = new CustomerServiceId(request.id());
        CustomerId customerId = new CustomerId(request.customerId());
        ServiceId serviceId = new ServiceId(request.serviceId());

        Customer customer = customerFinder.find(customerId);
        Service service = serviceFinder.find(serviceId);

        ensureServiceDoesNotAlreadyExistInCustomer(customerId, serviceId);

        CustomerService customerService = new CustomerService(id, customer.id(), service.id());

        this.repository.save(customerService);
    }

    private void ensureServiceDoesNotAlreadyExistInCustomer(CustomerId customerId, ServiceId serviceId) {
        Optional<CustomerService> customerService = customerServiceFinder.find(customerId, serviceId);
        if (customerService.isPresent()) {
            throw new CustomerServiceAlreadyExists(serviceId, customerId);
        }
    }
}
