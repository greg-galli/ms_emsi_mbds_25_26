package com.mbds.ms;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(Long customerId);
    List<CustomerDTO> getCustomers();
    CustomerDTO createCustomer(CustomerDTO customer);
}
