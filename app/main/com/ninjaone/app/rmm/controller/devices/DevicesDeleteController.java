package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.rmm.customers.application.DeviceDeleter;
import com.ninjaone.rmm.customers.domain.DeviceNotExist;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DevicesDeleteController extends ApiController {
    private final DeviceDeleter deleter;

    public DevicesDeleteController(DeviceDeleter deleter) {
        this.deleter = deleter;
    }

    @DeleteMapping("/devices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        deleter.delete(id);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(DeviceNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
