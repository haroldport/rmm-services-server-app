package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.domain.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ServiceFinder {
    private final ServiceRepository repository;

    public ServiceFinder(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceResponse> find() {
        return this.repository.searchAll()
            .stream()
            .map(ServiceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
