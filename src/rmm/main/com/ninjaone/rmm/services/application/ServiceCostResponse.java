package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.ServiceCost;

import java.io.Serializable;

public class ServiceCostResponse implements Serializable {
    private final String platform;
    private final Double price;

    public ServiceCostResponse(String platform, Double price) {
        this.platform = platform;
        this.price = price;
    }

    public static ServiceCostResponse fromAggregate(ServiceCost serviceCost) {
        return new ServiceCostResponse(
            serviceCost.getPlatform(),
            serviceCost.getPrice()
        );
    }

    public String platform() {
        return platform;
    }

    public Double price() {
        return price;
    }
}
