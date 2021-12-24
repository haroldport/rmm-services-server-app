package com.ninjaone.rmm.customers.application;

import com.ninjaone.rmm.customerServices.domain.CustomerServiceRepository;
import com.ninjaone.rmm.customers.domain.*;
import com.ninjaone.rmm.services.domain.Service;
import com.ninjaone.rmm.services.domain.ServiceRepository;

import java.util.List;

@com.ninjaone.shared.domain.Service
public final class CustomerMonthlyCostCalculator {
    private final AllServiceByCustomerFinder finder;
    private final CustomerDeviceFinder customerDeviceFinder;
    private final CostCalculator calculator;

    public CustomerMonthlyCostCalculator(CustomerServiceRepository repository, ServiceRepository serviceRepository,
                                         CustomerRepository customerRepository, DeviceRepository deviceRepository) {
        finder = new AllServiceByCustomerFinder(repository, serviceRepository, customerRepository);
        customerDeviceFinder = new CustomerDeviceFinder(customerRepository, deviceRepository);
        this.calculator = new CostCalculator();
    }

    public Double calculateCost(String customerId) {
        List<Service> services = finder.find(customerId);
        List<Device> devices = customerDeviceFinder.find(customerId);
        return calculator.calculate(services, devices);
    }
}
