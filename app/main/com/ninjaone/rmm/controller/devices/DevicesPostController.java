package com.ninjaone.rmm.controller.devices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevicesPostController {
    @PostMapping("/devices")
    public ResponseEntity create(@RequestBody Request request) {
        return new ResponseEntity(HttpStatus.CREATED);
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
