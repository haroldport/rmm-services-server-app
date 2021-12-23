package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customerServices.application.CustomerServiceDeleter;
import com.ninjaone.rmm.customerServices.domain.CustomerHasNoService;
import com.ninjaone.rmm.customers.domain.CustomerNotExist;
import com.ninjaone.rmm.services.domain.ServiceNotExist;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CustomersServiceDeleteController extends ApiController {
    private final CustomerServiceDeleter deleter;

    public CustomersServiceDeleteController(CustomerServiceDeleter deleter) {
        this.deleter = deleter;
    }

    @DeleteMapping("/customers/{customerId}/services/{serviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String customerId, @PathVariable String serviceId) {
        deleter.delete(customerId, serviceId);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
            put(ServiceNotExist.class, HttpStatus.NOT_FOUND);
            put(CustomerHasNoService.class, HttpStatus.CONFLICT);
        }};
    }
}
