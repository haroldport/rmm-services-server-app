package com.ninjaone.rmm.customerServices.domain;

import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.services.domain.ServiceId;
import com.ninjaone.shared.domain.DomainError;

public class CustomerHasNoService extends DomainError {
    public CustomerHasNoService(ServiceId serviceId, CustomerId customerId) {
        super(
            "customer_has_no_service",
            String.format("The customer <%s> has no service <%s> added.", customerId.value(), serviceId.value())
        );
    }
}
