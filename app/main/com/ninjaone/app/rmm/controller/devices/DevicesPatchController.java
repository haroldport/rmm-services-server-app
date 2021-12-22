package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.rmm.customers.application.DeviceUpdater;
import com.ninjaone.rmm.customers.application.DeviceUpdaterRequest;
import com.ninjaone.rmm.customers.domain.DeviceNotExist;
import com.ninjaone.rmm.customers.domain.DeviceTypeInvalid;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class DevicesPatchController extends ApiController {
    private final DeviceUpdater updater;

    public DevicesPatchController(DeviceUpdater updater) {
        this.updater = updater;
    }

    @PatchMapping("/devices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody DeviceUpdateRequest request) {
        updater.update(new DeviceUpdaterRequest(id, Optional.ofNullable(request.systemName()), Optional.ofNullable(request.type())));
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(DeviceTypeInvalid.class, HttpStatus.BAD_REQUEST);
            put(DeviceNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
