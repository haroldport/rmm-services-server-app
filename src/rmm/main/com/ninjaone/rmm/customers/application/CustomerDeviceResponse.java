package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.Device;
import com.ninjaone.rmm.customers.domain.DeviceType;

import java.io.Serializable;

public class CustomerDeviceResponse implements Serializable {
    private final String id;
    private final String systemName;
    private final String type;

    public CustomerDeviceResponse(String id, String systemName, String type) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
    }

    public static CustomerDeviceResponse fromAggregate(Device device) {
        return new CustomerDeviceResponse(
            device.id().value(),
            device.systemName().value(),
            DeviceType.getValidDeviceTypes().get(device.type().value())
        );
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
