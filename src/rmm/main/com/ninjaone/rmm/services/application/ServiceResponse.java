package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceResponse implements Serializable {
    private final String id;
    private final String name;
    private final List<ServiceCostResponse> costs;

    public ServiceResponse(String id, String name, List<ServiceCostResponse> costs) {
        this.id = id;
        this.name = name;
        this.costs = costs;
    }

    public static ServiceResponse fromAggregate(Service service) {
        return new ServiceResponse(
            service.id().value(),
            service.name().value(),
            service.costs().stream().map(ServiceCostResponse::fromAggregate).collect(Collectors.toList())
        );
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<ServiceCostResponse> costs() {
        return costs;
    }
}
