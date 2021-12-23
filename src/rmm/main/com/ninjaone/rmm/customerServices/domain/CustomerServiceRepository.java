package com.ninjaone.rmm.customerServices.domain;

import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;

public interface CustomerServiceRepository {
    void save(CustomerService customerService);

    void delete(CustomerService customerService);

    List<CustomerService> matching(Criteria criteria);
}
