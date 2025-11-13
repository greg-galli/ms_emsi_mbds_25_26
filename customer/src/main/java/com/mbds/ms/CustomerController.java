package com.mbds.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId)
    {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

}
