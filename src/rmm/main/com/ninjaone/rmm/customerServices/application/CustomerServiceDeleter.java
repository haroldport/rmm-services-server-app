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
public final class CustomerServiceDeleter {
    private final CustomerServiceRepository repository;
    private final CustomerFinder customerFinder;
    private final ServiceFinder serviceFinder;
    private final CustomerServiceFinder customerServiceFinder;

    public CustomerServiceDeleter(CustomerServiceRepository repository, CustomerRepository customerRepository,
                                  ServiceRepository serviceRepository) {
        this.repository = repository;
        customerFinder = new CustomerFinder(customerRepository);
        serviceFinder = new ServiceFinder(serviceRepository);
        customerServiceFinder = new CustomerServiceFinder(repository);
    }

    public void delete(String customerId, String serviceId) {
        CustomerId customerIdVo = new CustomerId(customerId);
        ServiceId serviceIdVo = new ServiceId(serviceId);

        Customer customer = customerFinder.find(customerIdVo);
        Service service = serviceFinder.find(serviceIdVo);

        CustomerService customerService = ensureServiceExistInCustomer(customer.id(), service.id());

        this.repository.delete(customerService);
    }

    private CustomerService ensureServiceExistInCustomer(CustomerId customerId, ServiceId serviceId) {
        Optional<CustomerService> customerService = customerServiceFinder.find(customerId, serviceId);
        if (!customerService.isPresent()) {
            throw new CustomerHasNoService(serviceId, customerId);
        }
        return customerService.get();
    }
}
