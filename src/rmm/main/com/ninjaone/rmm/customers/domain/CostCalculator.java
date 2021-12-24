package com.ninjaone.rmm.customers.domain;

import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceCost;

import java.util.List;

@com.ninjaone.shared.domain.Service
public class CostCalculator {

    public static final double DEVICE_COST = 4d;

    public Double calculate(List<Service> services, List<Device> devices) {
        Double deviceCost = devices.size() * DEVICE_COST;

        Double servicesCost = devices.stream()
            .map(Device::type)
            .flatMap(deviceType ->
                services.stream()
                    .map(Service::costs)
                    .flatMap(serviceCosts -> serviceCosts.stream()
                        .filter(cost -> deviceType.value().toLowerCase().contains(cost.getPlatform().toLowerCase()))
                        .map(ServiceCost::getPrice))
            )
            .reduce(Double::sum).orElse(0d);

        return deviceCost + servicesCost;
    }
}
