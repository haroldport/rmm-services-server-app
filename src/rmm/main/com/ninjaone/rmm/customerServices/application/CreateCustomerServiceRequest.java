package com.ninjaone.rmm.customerServices.application;

public final class CreateCustomerServiceRequest {
    private final String id;
    private final String customerId;
    private final String serviceId;

    public CreateCustomerServiceRequest(String id, String customerId, String serviceId) {
        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public String id() {
        return id;
    }

    public String customerId() {
        return customerId;
    }

    public String serviceId() {
        return serviceId;
    }
}
