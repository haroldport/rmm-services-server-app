package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.DomainError;

public class DeviceNotExist extends DomainError {
    public DeviceNotExist(DeviceId deviceId) {
        super(
            "device_not_exist",
            String.format("The device <%s> doesn't exist.", deviceId.value())
        );
    }
}
