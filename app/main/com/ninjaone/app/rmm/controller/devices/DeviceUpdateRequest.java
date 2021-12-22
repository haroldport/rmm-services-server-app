package com.ninjaone.app.rmm.controller.devices;

public class DeviceUpdateRequest {
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
