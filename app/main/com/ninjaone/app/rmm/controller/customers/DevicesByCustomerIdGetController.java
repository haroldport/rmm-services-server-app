package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customers.application.CustomerDeviceResponse;
import com.ninjaone.rmm.customers.application.DevicesByCustomerId;
import com.ninjaone.rmm.customers.domain.CustomerNotExist;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class DevicesByCustomerIdGetController extends ApiController {
    private final DevicesByCustomerId finder;

    public DevicesByCustomerIdGetController(DevicesByCustomerId finder) {
        this.finder = finder;
    }

    @GetMapping("/customers/{id}/devices")
    public HashMap<String, List<HashMap<String, String>>> index(@PathVariable String id) {
        List<CustomerDeviceResponse> devices = this.finder.find(id);

        return new HashMap<String, List<HashMap<String, String>>>() {{
            put("data",
                devices.stream().map(response -> new HashMap<String, String>() {{
                    put("id", response.id());
                    put("systemName", response.systemName());
                    put("type", response.type());
                }}).collect(Collectors.toList()));
        }};
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
