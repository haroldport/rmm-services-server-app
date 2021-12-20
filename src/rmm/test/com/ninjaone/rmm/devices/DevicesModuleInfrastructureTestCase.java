package com.ninjaone.rmm.devices;


import com.ninjaone.rmm.devices.infrastructure.persistence.InMemoryDeviceRepository;
import com.ninjaone.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class DevicesModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryDeviceRepository repository;
}
