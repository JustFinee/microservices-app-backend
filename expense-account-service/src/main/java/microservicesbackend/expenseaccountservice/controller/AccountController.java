package microservicesbackend.expenseaccountservice.controller;

import microservicesbackend.expenseaccountservice.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount/{userId}")
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {

        return null;
    }
}
