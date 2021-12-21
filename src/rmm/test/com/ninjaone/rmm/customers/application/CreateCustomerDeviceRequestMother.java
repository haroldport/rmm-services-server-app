package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;

public final class CreateCustomerDeviceRequestMother {
    public static CreateCustomerDeviceRequest create(DeviceId id, DeviceSystemName systemName, DeviceType type, CustomerId customerId) {
        return new CreateCustomerDeviceRequest(id.value(), systemName.value(), type.value(), customerId.value());
    }

    public static CreateCustomerDeviceRequest randomWithValidDeviceType(CustomerId customerId) {
        return create(DeviceIdMother.random(), DeviceSystemNameMother.random(), DeviceTypeMother.randomValidValues(), customerId);
    }

    public static CreateCustomerDeviceRequest randomWithInvalidDeviceType() {
        return create(DeviceIdMother.random(), DeviceSystemNameMother.random(), DeviceTypeMother.randomInvalidValues(), CustomerIdMother.random());
    }
}
