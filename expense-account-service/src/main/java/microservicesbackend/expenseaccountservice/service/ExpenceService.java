package microservicesbackend.expenseaccountservice.service;

import com.netflix.discovery.converters.Auto;
import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.dto.SumDto;
import microservicesbackend.expenseaccountservice.entity.Account;
import microservicesbackend.expenseaccountservice.entity.Expence;
import microservicesbackend.expenseaccountservice.entity.Type;
import microservicesbackend.expenseaccountservice.repository.AccountRepository;
import microservicesbackend.expenseaccountservice.repository.ExpenceRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.font.OpenType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Expence transfer(Long idUser,Long from, Long to, int amount) throws NotFoundException, IllegalStateException
    {
        Optional<Account> fromAccount = accountRepository.findById(from);
        Optional<Account> toAccount = accountRepository.findById(to);
        if (fromAccount.isEmpty() || toAccount.isEmpty()) throw new NotFoundException("There is no account with with id: " +from + "or "+ to);
        SumDto isPosibbleToTransfer = findAccountsWithSum(idUser).stream().filter(x-> x.getAccount().getAccountId() == from).findFirst().get();

        if (isPosibbleToTransfer.getSum()<amount) throw new IllegalStateException("There is no enough money for transfer");

        Expence transferOut = new Expence(idUser,fromAccount.get(),-amount, LocalDateTime.now(),
                "Transfer OUT",null, Type.TRANSFER_OUT);

        Expence transferIn = new Expence(idUser,toAccount.get(),amount,LocalDateTime.now(),
                "Transfer IN",null,Type.TRANSFER_IN);

        expenceRepository.save(transferOut);
        expenceRepository.save(transferIn);

        return transferIn;
    }

    public Integer findSum(Long userId) throws NotFoundException
    {
        List<Expence> expences = expenceRepository.findAllByIdUser(userId);
        if (expences.isEmpty()) throw new NotFoundException("There is no expences in this user");
        return expences.stream()
                .map(x-> x.getAmount())
                .reduce(0,Integer::sum);
    }

    public List<SumDto> findAccountsWithSum(Long userId) throws NotFoundException
    {
        List<Account> accounts = accountRepository.findAllByIdUser(userId);
        List<Expence> expences = expenceRepository.findAllByIdUser(userId);
        if (expences.isEmpty()) throw new NotFoundException("There is no expences in this user");


        List<SumDto> sumList = accounts.stream()
                .map(x-> {
                    int sum = expences.stream()
                        .filter(y-> Long.compare(y.getAccount().getAccountId(),x.getAccountId())==0)
                        .map(z-> z.getAmount())
                        .reduce(0,Integer::sum);
                    SumDto sumDto = new SumDto(x,sum);
                    return sumDto;
                }).collect(Collectors.toList());

        return sumList;


    }
}
