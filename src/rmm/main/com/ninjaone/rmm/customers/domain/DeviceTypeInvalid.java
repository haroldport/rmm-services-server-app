package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.DomainError;

public class DeviceTypeInvalid extends DomainError {
    public DeviceTypeInvalid(String type) {
        super(
            "device_type_invalid",
            String.format("The device type %s is invalid", type)
        );
    }
}
