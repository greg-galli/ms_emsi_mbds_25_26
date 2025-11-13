package fr.miage.mbds.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getCustomers().forEach(
                    customer -> {
                        Account a1 = Account.builder()
                                .balance(1000.0)
                                .currencyType(CurrencyType.EUR)
                                .customerId(customer.getId())
                                .build();
                        accountRepository.saveAndFlush(a1);
                    }
            );

        };
    }
}
