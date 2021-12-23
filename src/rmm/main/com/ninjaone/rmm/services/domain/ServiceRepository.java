package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);

    Optional<Service> search(ServiceId id);

    List<Service> matching(Criteria criteria);

    List<Service> searchAll();
}
