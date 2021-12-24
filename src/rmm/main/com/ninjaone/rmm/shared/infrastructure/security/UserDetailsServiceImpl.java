package com.ninjaone.rmm.shared.infrastructure.security;

import com.ninjaone.rmm.customers.domain.Customer;
import com.ninjaone.rmm.customers.domain.CustomerRepository;
import com.ninjaone.shared.domain.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Filter usernameFilter = Filter.create("username", FilterOperator.EQUAL.value(), username);
        Criteria usernameCriteria = new Criteria(
            new Filters(Collections.singletonList(usernameFilter)),
            Order.asc("username")
        );
        List<Customer> customers = customerRepository.matching(usernameCriteria);
        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }

        return UserDetailsImpl.build(customers.get(0));
    }
}
