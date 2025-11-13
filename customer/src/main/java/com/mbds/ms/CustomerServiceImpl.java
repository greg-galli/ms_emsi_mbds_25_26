package com.mbds.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements  CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerMapper.toDTOList(customerList);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(customerMapper.toEntity(customerDTO));
        return customerMapper.toDTO(customer);
    }
}
