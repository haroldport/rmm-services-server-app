package com.ninjaone.rmm.customerServices.domain;

import com.ninjaone.rmm.customers.domain.CustomerId;
import com.ninjaone.rmm.services.domain.ServiceId;
import com.ninjaone.shared.domain.DomainError;

public class CustomerServiceAlreadyExists extends DomainError {
    public CustomerServiceAlreadyExists(ServiceId serviceId, CustomerId customerId) {
        super(
            "customer_service_already_exists",
            String.format("Service <%s> is already exists in customer <%s>.", serviceId.value(), customerId.value())
        );
    }
}
