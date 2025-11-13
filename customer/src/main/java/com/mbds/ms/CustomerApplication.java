package com.mbds.ms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = new ArrayList<>();
            customerList.add(Customer.builder()
                    .firstName("John")
                    .lastName("Smith")
                    .email("john.smith@gmail.com")
                    .build()
            );
            customerList.add(Customer.builder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .email("jane.smith@gmail.com")
                    .build()
            );
            customerList.add(Customer.builder()
                    .firstName("Bob")
                    .lastName("Smith")
                    .email("bob.smith@gmail.com")
                    .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
