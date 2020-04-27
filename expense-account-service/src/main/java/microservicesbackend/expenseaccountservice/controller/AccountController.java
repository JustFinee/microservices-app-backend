package microservicesbackend.expenseaccountservice.controller;

import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Account;
import microservicesbackend.expenseaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/getAccount/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountId") Long accountId) {
        try {
            return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found account with this id", e);
        }
    }

    @GetMapping("/getAllUserAccounts/{idUser}")
    public ResponseEntity<List<Account>> getAllAccounts(@PathVariable("idUser") Long idUser) {
        try {
            return new ResponseEntity<>(accountService.getAllAccounts(idUser), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found this user"
            );
        }
    }

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        if (createdAccount != null)
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/changeAccount")
    public ResponseEntity<Account> changeAccount(@RequestBody Account account) {
        try {
            return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found account with this id", e);
        }
    }

    @DeleteMapping("/deleteAccount/{idAccount}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("idAccount") Long idAccount) {
        try {
            accountService.deleteAccount(idAccount);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found account with this id", e);
        }
    }
}
