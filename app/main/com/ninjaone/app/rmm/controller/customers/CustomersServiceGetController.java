package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.app.rmm.controller.util.Util;
import com.ninjaone.rmm.customers.application.AllCustomerServiceFinder;
import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public final class CustomersServiceGetController extends ApiController {
    private final AllCustomerServiceFinder finder;

    public CustomersServiceGetController(AllCustomerServiceFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/customers/{customerId}/services")
    public HashMap<String, List<HashMap<String, Object>>> index(@PathVariable String customerId) {
        List<ServiceResponse> services = this.finder.find(customerId);

        return Util.getServiceResponse(services);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
