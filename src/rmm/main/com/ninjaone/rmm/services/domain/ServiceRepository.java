package com.ninjaone.rmm.services.domain;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);

    Optional<Service> search(ServiceId id);

    List<Service> searchAll();
}
