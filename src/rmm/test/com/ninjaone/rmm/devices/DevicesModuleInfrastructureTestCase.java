package com.ninjaone.rmm.devices;


import com.ninjaone.rmm.devices.infrastructure.InMemoryDeviceRepository;
import com.ninjaone.shared.infrastructure.InfrastructureTestCase;

public class DevicesModuleInfrastructureTestCase extends InfrastructureTestCase {
    protected InMemoryDeviceRepository repository = new InMemoryDeviceRepository();
}
