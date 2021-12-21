package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceCreator {
    private final CustomerRepository repository;
    private final CustomerFinder customerFinder;

    public CustomerDeviceCreator(CustomerRepository repository) {
        this.repository = repository;
        customerFinder = new CustomerFinder(repository);
    }

    public void create(CreateCustomerDeviceRequest request) {
        DeviceId id = new DeviceId(request.id());
        DeviceSystemName systemName = new DeviceSystemName(request.systemName());
        DeviceType type = new DeviceType(request.type());
        CustomerId customerId = new CustomerId(request.customerId());

        Customer customer = customerFinder.find(customerId);

        Device device = new Device(id, systemName, type, customerId);

        customer.addOrUpdateDevice(device);

        this.repository.save(customer);
    }
}
