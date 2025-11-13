package com.mbds.ms;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long customerId);
    List<Customer> getCustomers();
    Customer createCustomer(Customer customer);
}
