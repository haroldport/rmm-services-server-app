package com.ninjaone.rmm.customers.domain;

import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceCost;
import com.ninjaone.rmm.services.domain.ServiceIdMother;
import com.ninjaone.rmm.services.domain.ServiceNameMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CostCalculatorShould {
    private CostCalculator calculator;
    private List<Service> services;
    private List<Device> devices;

    @BeforeEach
    protected void setUp(){
        calculator = new CostCalculator();
    }

    @Test
    void get_right_result_when_customer_has_five_devices_and_three_services() {
        services = Arrays.asList(
            new Service(
                ServiceIdMother.random(),
                ServiceNameMother.random(),
                Arrays.asList(new ServiceCost("Windows", 1d), new ServiceCost("Mac", 1d))
            ),
            new Service(
                ServiceIdMother.random(),
                ServiceNameMother.random(),
                Arrays.asList(new ServiceCost("Windows", 3d), new ServiceCost("Mac", 3d))
            ),
            new Service(
                ServiceIdMother.random(),
                ServiceNameMother.random(),
                Arrays.asList(new ServiceCost("Windows", 5d), new ServiceCost("Mac", 7d))
            )
        );
        devices = Arrays.asList(
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("MAC"), CustomerIdMother.random()),
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("MAC"), CustomerIdMother.random()),
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("MAC"), CustomerIdMother.random()),
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("WINDOWS_SERVER"), CustomerIdMother.random()),
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("WINDOWS_SERVER"), CustomerIdMother.random())
        );

        Double result = calculator.calculate(services, devices);
        assertEquals(71d, result, 1.0);
    }

    @Test
    void get_right_result_when_customer_has_two_devices_and_two_services() {
        services = Arrays.asList(
            new Service(
                ServiceIdMother.random(),
                ServiceNameMother.random(),
                Arrays.asList(new ServiceCost("Windows", 1d), new ServiceCost("Mac", 1d))
            ),
            new Service(
                ServiceIdMother.random(),
                ServiceNameMother.random(),
                Arrays.asList(new ServiceCost("Windows", 5d), new ServiceCost("Mac", 7d))
            )
        );
        devices = Arrays.asList(
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("MAC"), CustomerIdMother.random()),
            new Device(DeviceIdMother.random(), DeviceSystemNameMother.random(),
                new DeviceType("WINDOWS_SERVER"), CustomerIdMother.random())
        );

        Double result = calculator.calculate(services, devices);
        assertEquals(22d, result, 1.0);
    }

}
