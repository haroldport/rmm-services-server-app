package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.DomainError;

public class ServiceNotExist extends DomainError {
    public ServiceNotExist(ServiceId serviceId) {
        super(
            "service_not_exist",
            String.format("The service <%s> doesn't exist.", serviceId.value())
        );
    }
}
