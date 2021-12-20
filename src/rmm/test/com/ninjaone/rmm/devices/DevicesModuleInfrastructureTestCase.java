package com.ninjaone.rmm.devices;


import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.infrastructure.InMemoryDeviceRepository;
import com.ninjaone.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class DevicesModuleInfrastructureTestCase extends InfrastructureTestCase {
    protected InMemoryDeviceRepository inMemoryDeviceRepository = new InMemoryDeviceRepository();

    @Autowired
    protected DeviceRepository postgresDeviceRepository;
}
