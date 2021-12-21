package com.ninjaone.app.rmm.controller.customers;

public final class CreateCustomerDeviceRequest {
    private String systemName;
    private String type;

    String systemName() {
        return systemName;
    }

    String type() {
        return type;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setType(String type) {
        this.type = type;
    }
}
