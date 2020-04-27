package microservicesbackend.expenseaccountservice.service;

import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Account;
import microservicesbackend.expenseaccountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account getAccount(Long idAccount) throws NotFoundException
    {
        Optional<Account> account = accountRepository.findById(idAccount);
        if (account.isEmpty()) throw new NotFoundException("There is no account with id "+ idAccount);
        return account.get();
    }

    public List<Account> getAllAccounts(Long idUser) throws NotFoundException
    {
        List<Account> accounts = accountRepository.findAllByIdUser(idUser);
        if (accounts.isEmpty()) throw new NotFoundException("There is no accounts with this idUser");
        return accounts;
    }

    public Account createAccount(Account account)
    {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) throws NotFoundException
    {
        if (accountRepository.findById(account.getAccountId()).isEmpty()) throw new NotFoundException("There no account with id "+account.getAccountId());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long idAccount) throws NotFoundException
    {
        if (accountRepository.findById(idAccount).isEmpty()) throw new NotFoundException("There no account with id "+ idAccount);

        accountRepository.deleteById(idAccount);
    }




}
