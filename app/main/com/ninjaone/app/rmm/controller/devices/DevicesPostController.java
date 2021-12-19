package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.rmm.devices.application.DeviceCreator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DevicesPostController {
    private final DeviceCreator creator;

    public DevicesPostController(DeviceCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/devices")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Request request) {
        creator.create(UUID.randomUUID().toString(), request.systemName(), request.type());
    }
}

final class Request {
    private String systemName;
    private String type;

    String systemName() {
        return systemName;
    }

    String type() {
        return type;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setType(String type) {
        this.type = type;
    }
}
