package com.ninjaone.rmm.customerServices.application;

import com.ninjaone.rmm.customerServices.domain.CustomerService;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceAlreadyExists;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceId;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerFinder;
import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceFinder;
import com.ninjaone.rmm.services.domain.ServiceId;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.domain.criteria.*;

import java.util.Arrays;
import java.util.List;

@com.ninjaone.shared.domain.Service
public final class CustomerServiceCreator {
    private final CustomerServiceRepository repository;
    private final CustomerFinder customerFinder;
    private final ServiceFinder serviceFinder;

    public CustomerServiceCreator(CustomerServiceRepository repository, CustomerRepository customerRepository,
                                  ServiceRepository serviceRepository) {
        this.repository = repository;
        customerFinder = new CustomerFinder(customerRepository);
        serviceFinder = new ServiceFinder(serviceRepository);
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
        Filter customerFilter = Filter.create("customerId", FilterOperator.EQUAL.value(), customerId.value());
        Filter serviceFilter = Filter.create("serviceId", FilterOperator.EQUAL.value(), serviceId.value());
        Criteria customerServiceCriteria = new Criteria(
            new Filters(Arrays.asList(customerFilter, serviceFilter)),
            Order.asc("id")
        );
        List<CustomerService> customerServices = this.repository.matching(customerServiceCriteria);
        if (customerServices.size() > 0) {
            throw new CustomerServiceAlreadyExists(serviceId, customerId);
        }
    }
}
