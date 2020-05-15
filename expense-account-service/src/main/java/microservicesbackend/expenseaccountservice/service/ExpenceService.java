package microservicesbackend.expenseaccountservice.service;

import com.netflix.discovery.converters.Auto;
import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Account;
import microservicesbackend.expenseaccountservice.entity.Expence;
import microservicesbackend.expenseaccountservice.entity.Type;
import microservicesbackend.expenseaccountservice.repository.AccountRepository;
import microservicesbackend.expenseaccountservice.repository.ExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.font.OpenType;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenceService {

    @Autowired
    ExpenceRepository expenceRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<Expence> getExpences(Long userId, Date from, Date to)
    {
        return expenceRepository.getExpences(userId,from,to);
    }

    public Expence createExpence(Expence expence)
    {
        return expenceRepository.save(expence);
    }

    public Expence transfer(Long idUser,Long from, Long to, int amount) throws NotFoundException
    {
        Optional<Account> fromAccount = accountRepository.findById(from);
        Optional<Account> toAccount = accountRepository.findById(to);
        if (fromAccount.isEmpty() || toAccount.isEmpty()) throw new NotFoundException("There is no account with with id: " +from + "or "+ to);

        Expence transferOut = new Expence(idUser,fromAccount.get(),amount, Date.valueOf(LocalDate.now()),
                "Transfer OUT",null, Type.TRANSFER_OUT);

        Expence transferIn = new Expence(idUser,toAccount.get(),amount,Date.valueOf(LocalDate.now()),
                "Transfer IN",null,Type.TRANSFER_IN);

        expenceRepository.save(transferOut);
        expenceRepository.save(transferIn);

        return transferIn;
    }
}
