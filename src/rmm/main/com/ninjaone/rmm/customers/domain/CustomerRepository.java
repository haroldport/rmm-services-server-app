package com.ninjaone.rmm.customers.domain;

import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);

    Optional<Customer> search(CustomerId id);

    List<Customer> matching(Criteria criteria);
}
