package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customers.application.CustomerCreator;
import com.ninjaone.rmm.customers.domain.CustomerAlreadyExists;
import com.ninjaone.rmm.customers.domain.CustomerPasswordInvalid;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class CustomersPostController extends ApiController {
    private final CustomerCreator creator;
    private final PasswordEncoder encoder;

    public CustomersPostController(CustomerCreator creator, PasswordEncoder encoder) {
        this.creator = creator;
        this.encoder = encoder;
    }

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CustomerCredentialsRequest request) {
        creator.create(new com.ninjaone.rmm.customers.application.CreateCustomerRequest(
            UUID.randomUUID().toString(), request.username(), request.password(),
            encoder.encode(request.password()))
        );
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerPasswordInvalid.class, HttpStatus.BAD_REQUEST);
            put(CustomerAlreadyExists.class, HttpStatus.CONFLICT);
        }};
    }
}
