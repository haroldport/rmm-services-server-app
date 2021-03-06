package com.ninjaone.rmm.services.application;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.shared.domain.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AllServiceFinder {
    private final ServiceRepository repository;

    public AllServiceFinder(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceResponse> find() {
        return this.repository.searchAll()
            .stream()
            .map(ServiceResponse::fromAggregate)
            .collect(Collectors.toList());
    }
}
