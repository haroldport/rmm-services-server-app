package com.ninjaone.rmm.services.domain;

import java.util.List;
import java.util.Objects;

public final class Service {
    private final ServiceId id;
    private final ServiceName name;
    private final List<ServiceCost> costs;

    public Service(ServiceId id, ServiceName name, List<ServiceCost> costs) {
        this.id = id;
        this.name = name;
        this.costs = costs;
    }

    public Service() {
        this.id = null;
        this.name = null;
        this.costs = null;
    }

    public ServiceId id() {
        return id;
    }

    public ServiceName name() {
        return name;
    }

    @Override
    public String toString() {
        return id.value();
    }

    public List<ServiceCost> costs() {
        return costs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id.equals(service.id) && name.equals(service.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
