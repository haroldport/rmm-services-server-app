package com.ninjaone.rmm.services.domain;

@com.ninjaone.shared.domain.Service
public class ServiceFinder {
    private final ServiceRepository repository;

    public ServiceFinder(ServiceRepository repository) {
        this.repository = repository;
    }

    public Service find(ServiceId serviceId) {
        return this.repository.search(serviceId).orElseThrow(() -> new ServiceNotExist(serviceId));
    }
}
