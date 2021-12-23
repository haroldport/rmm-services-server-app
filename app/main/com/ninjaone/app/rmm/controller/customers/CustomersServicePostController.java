package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customerServices.application.CreateCustomerServiceRequest;
import com.ninjaone.rmm.customerServices.application.CustomerServiceCreator;
import com.ninjaone.rmm.customerServices.domain.CustomerServiceAlreadyExists;
import com.ninjaone.rmm.customers.domain.CustomerNotExist;
import com.ninjaone.rmm.services.domain.ServiceNotExist;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class CustomersServicePostController extends ApiController {
    private final CustomerServiceCreator creator;

    public CustomersServicePostController(CustomerServiceCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/customers/{customerId}/services/{serviceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable String customerId, @PathVariable String serviceId) {
        creator.create(new CreateCustomerServiceRequest(
            UUID.randomUUID().toString(), customerId, serviceId)
        );
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
            put(ServiceNotExist.class, HttpStatus.NOT_FOUND);
            put(CustomerServiceAlreadyExists.class, HttpStatus.CONFLICT);
        }};
    }
}
