package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.rmm.devices.application.CreateDeviceRequest;
import com.ninjaone.rmm.devices.application.DeviceCreator;
import com.ninjaone.rmm.devices.domain.DeviceTypeInvalid;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class DevicesPostController extends ApiController {
    private final DeviceCreator creator;

    public DevicesPostController(DeviceCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/devices")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Request request) {
        creator.create(new CreateDeviceRequest(UUID.randomUUID().toString(), request.systemName(), request.type()));
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(DeviceTypeInvalid.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
