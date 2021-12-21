package com.ninjaone.rmm.customers.domain;

import com.ninjaone.rmm.customers.application.CreateCustomerDeviceRequest;

public class DeviceMother {
    public static Device create(DeviceId id, DeviceSystemName systemName, DeviceType type, CustomerId customerId) {
        return new Device(id, systemName, type, customerId);
    }

    public static Device fromRequest(CreateCustomerDeviceRequest request) {
        return create(
            DeviceIdMother.create(request.id()),
            DeviceSystemNameMother.create(request.systemName()),
            DeviceTypeMother.create(request.type()),
            CustomerIdMother.create(request.customerId())
        );
    }

    public static Device random(CustomerId customerId) {
        return create(
            DeviceIdMother.random(),
            DeviceSystemNameMother.random(),
            DeviceTypeMother.randomValidValues(),
            customerId
        );
    }
}
