package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository {
    void save(Device device);

    Optional<Device> search(DeviceId id);

    List<Device> matching(Criteria criteria);
}
