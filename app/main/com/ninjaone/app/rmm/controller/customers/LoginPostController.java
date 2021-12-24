package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customers.domain.CustomerPasswordInvalid;
import com.ninjaone.rmm.shared.infrastructure.security.JwtUtils;
import com.ninjaone.rmm.shared.infrastructure.security.UserDetailsImpl;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.config.ParameterNotExist;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginPostController extends ApiController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public LoginPostController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, HashMap<String, String>> index(@RequestBody CustomerCredentialsRequest request) throws ParameterNotExist {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new HashMap<String, HashMap<String, String>>() {{
            put("data", new HashMap<String, String>() {{
                put("accessToken", jwt);
                put("tokenType", "Bearer");
                put("customerId", userDetails.getId());
                put("customerUsername", userDetails.getUsername());
            }});
        }};
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerPasswordInvalid.class, HttpStatus.BAD_REQUEST);
        }};
    }
}
