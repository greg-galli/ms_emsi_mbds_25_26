package fr.miage.mbds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;

    @Autowired
    public AccountController(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts()
    {
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach( account -> {
            account.setCustomer(customerClient.getCustomerById(account.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccountById(@PathVariable String accountId)
    {
        Account accountInstance = accountRepository.findById(accountId).orElse(null);
        accountInstance.setCustomer(customerClient.getCustomerById(accountInstance.getCustomerId()));
        return accountInstance;
    }
}
