package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.services.application.ServiceFinder;
import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ServicesGetController extends ApiController {
    private final ServiceFinder finder;

    public ServicesGetController(ServiceFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/services")
    public HashMap<String, List<HashMap<String, Object>>> index() {
        List<ServiceResponse> services = this.finder.find();

        return new HashMap<String, List<HashMap<String, Object>>>() {{
            put("data",
                services.stream().map(response -> new HashMap<String, Object>() {{
                    put("id", response.id());
                    put("systemName", response.name());
                    put("costs",
                            response.costs().stream().map(cost -> new HashMap<String, Object>() {{
                                put("platform", cost.platform());
                                put("price", cost.price());
                            }}).collect(Collectors.toList())
                    );
                }}).collect(Collectors.toList()));
        }};
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
