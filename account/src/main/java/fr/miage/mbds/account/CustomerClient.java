package fr.miage.mbds.account;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER")
public interface CustomerClient {

    @GetMapping("/customers/{customerId}")
    @CircuitBreaker( name = "customer", fallbackMethod = "getDefaultCustomer")
    CustomerProxy getCustomerById(@PathVariable Long customerId);

    @GetMapping("/customers")
    @CircuitBreaker( name = "customers", fallbackMethod = "getDefaultCustomerList")
    List<CustomerProxy> getCustomers();

    default CustomerProxy getDefaultCustomer(Long customerId, Exception exception) {
        return CustomerProxy.builder()
                .firstName("Indisponible")
                .lastName("Indisponible")
                .email("Indisponible")
                .build();
    }

    default List<CustomerProxy> getDefaultCustomerList(Exception exception) {
        return List.of();
    }
}
