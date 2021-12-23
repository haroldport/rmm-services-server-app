package com.ninjaone.rmm.customerServices.domain;

import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.services.domain.ServiceId;

import java.util.Objects;

public final class CustomerService {
    private final CustomerServiceId id;
    private final CustomerId customerId;
    private final ServiceId serviceId;

    public CustomerService(CustomerServiceId id, CustomerId customerId, ServiceId serviceId) {
        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public CustomerService() {
        this.id = null;
        this.customerId = null;
        this.serviceId = null;
    }

    public CustomerServiceId id() {
        return id;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public ServiceId serviceId() {
        return serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerService that = (CustomerService) o;
        return id.equals(that.id) && customerId.equals(that.customerId) && serviceId.equals(that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, serviceId);
    }
}
