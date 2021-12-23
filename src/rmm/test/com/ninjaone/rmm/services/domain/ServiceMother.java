package com.ninjaone.rmm.services.domain;

import java.util.Arrays;
import java.util.List;

public class ServiceMother {
    public static Service create(ServiceId id, ServiceName name, List<ServiceCost> costs) {
        return new Service(id, name, costs);
    }

    public static Service random() {
        ServiceCost serviceCost = new ServiceCost("Windows", 5d);
        ServiceCost anotherServiceCost = new ServiceCost("Mac", 5d);

        return create(
            ServiceIdMother.random(),
            ServiceNameMother.random(),
            Arrays.asList(serviceCost, anotherServiceCost)
        );
    }
}
