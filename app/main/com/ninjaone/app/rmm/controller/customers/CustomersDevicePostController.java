package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customers.application.CustomerDeviceCreator;
import com.ninjaone.rmm.customers.application.CreateCustomerDeviceRequest;
import com.ninjaone.rmm.customers.domain.CustomerNotExist;
import com.ninjaone.rmm.customers.domain.DeviceTypeInvalid;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class CustomersDevicePostController extends ApiController {
    private final CustomerDeviceCreator creator;

    public CustomersDevicePostController(CustomerDeviceCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/customers/{id}/devices")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable String id, @RequestBody CreateCustomerDeviceRequest request) {
        creator.create(new CreateCustomerDeviceRequest(UUID.randomUUID().toString(), request.systemName(), request.type(), id));
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(DeviceTypeInvalid.class, HttpStatus.BAD_REQUEST);
            put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
