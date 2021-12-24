package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.CustomerDeviceFinder;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.rmm.customers.domain.Device;
import com.ninjaone.rmm.customers.domain.DeviceRepository;
import com.ninjaone.shared.domain.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class DevicesByCustomerId {
    private final CustomerDeviceFinder customerDeviceFinder;

    public DevicesByCustomerId(CustomerRepository repository, DeviceRepository deviceRepository) {
        customerDeviceFinder = new CustomerDeviceFinder(repository, deviceRepository);
    }

    public List<CustomerDeviceResponse> find(String customerId) {
        List<Device> devices = customerDeviceFinder.find(customerId);
        return devices
            .stream()
            .map(CustomerDeviceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
