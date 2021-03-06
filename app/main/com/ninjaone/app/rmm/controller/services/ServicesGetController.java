package com.ninjaone.app.rmm.controller.services;

import com.ninjaone.app.rmm.controller.util.Util;
import com.ninjaone.rmm.services.application.AllServiceFinder;
import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public final class ServicesGetController extends ApiController {
    private final AllServiceFinder finder;

    public ServicesGetController(AllServiceFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/services")
    public HashMap<String, List<HashMap<String, Object>>> index() {
        List<ServiceResponse> services = this.finder.find();

        return Util.getServiceResponse(services);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
