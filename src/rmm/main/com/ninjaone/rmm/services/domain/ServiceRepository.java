package com.ninjaone.rmm.services.domain;

import java.util.List;

public interface ServiceRepository {
    void save(Service service);

    List<Service> searchAll();
}
