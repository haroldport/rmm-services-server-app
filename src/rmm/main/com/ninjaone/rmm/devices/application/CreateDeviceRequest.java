package com.ninjaone.rmm.devices.application;

public final class CreateDeviceRequest {
    private final String id;
    private final String systemName;
    private final String type;

    public CreateDeviceRequest(String id, String systemName, String type) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
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
}
