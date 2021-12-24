package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.rmm.customers.application.CustomerMonthlyCostCalculator;
import com.ninjaone.rmm.customers.domain.CustomerNotExist;
import com.ninjaone.shared.domain.DomainError;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CalculateCustomerMonthlyCostGetController extends ApiController {
    private final CustomerMonthlyCostCalculator calculator;

    public CalculateCustomerMonthlyCostGetController(CustomerMonthlyCostCalculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/customers/{id}/calculate-monthly-cost")
    public HashMap<String, HashMap<String, Double>> index(@PathVariable String id) {
        Double cost = this.calculator.calculateCost(id);

        return new HashMap<String, HashMap<String, Double>>() {{
            put("data",
                new HashMap<String, Double>() {{
                    put("monthlyCost", cost);
                }});
        }};
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(CustomerNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
