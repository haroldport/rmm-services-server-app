package com.ninjaone.shared.infrastructure.spring;

import com.ninjaone.shared.domain.DomainError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {
    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
