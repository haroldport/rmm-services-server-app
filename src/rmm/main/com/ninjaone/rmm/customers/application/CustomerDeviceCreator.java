package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.shared.domain.Service;

@Service
public final class CustomerDeviceCreator {
    private final CustomerRepository repository;

    public CustomerDeviceCreator(CustomerRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCustomerDeviceRequest request) {
        DeviceId id = new DeviceId(request.id());
        DeviceSystemName systemName = new DeviceSystemName(request.systemName());
        DeviceType type = new DeviceType(request.type());
        CustomerId customerId = new CustomerId(request.customerId());

        Customer customer = ensureCustomerExists(customerId);

        Device device = new Device(id, systemName, type, customerId);

        customer.addOrUpdateDevice(device);

        this.repository.save(customer);
    }

    private Customer ensureCustomerExists(CustomerId customerId) {
        return this.repository.search(customerId).orElseThrow(() -> new CustomerNotExist(customerId));
    }
}
