package com.ninjaone.rmm.customers.application;

public final class CreateCustomerDeviceRequest {
    private final String id;
    private final String systemName;
    private final String type;
    private final String customerId;

    public CreateCustomerDeviceRequest(String id, String systemName, String type, String customerId) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
        this.customerId = customerId;
    }

    public String id() {
        return id;
    }

    public String systemName() {
        return systemName;
    }

    public String type() {
        return type;
    }

    public String customerId() {
        return customerId;
    }
}
