package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customers.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

final class DevicesByCustomerIdShould {
    private CustomerRepository customerRepository;
    private DeviceRepository repository;
    private DevicesByCustomerId finder;

    @BeforeEach
    void setUp(){
        customerRepository = mock(CustomerRepository.class);
        repository = mock(DeviceRepository.class);

        finder = new DevicesByCustomerId(customerRepository, repository);
    }

    @Test
    void retrieve_a_custom_device_response_list_with_one_element() {
        Customer customer = new Customer(new CustomerId("6c537f5c-032b-4ef8-925e-8fecc0b61c35"), new CustomerUserName("haroldport"), new CustomerPassword("Test1234"));


        List<Device> objects = new ArrayList<>();
        objects.add(DeviceMother.random(customer.id()));
        when(customerRepository.search(customer.id())).thenReturn(Optional.of(customer));
        when(repository.matching(any())).thenReturn(objects);

        CreateCustomerDeviceRequest request = CreateCustomerDeviceRequestMother.randomWithValidDeviceType(customer.id());

        Device device = DeviceMother.fromRequest(request);

        customer.addOrUpdateDevice(device);

        List<CustomerDeviceResponse> devices = finder.find(customer.id().value());
        assertEquals(1, devices.size());
    }
}
