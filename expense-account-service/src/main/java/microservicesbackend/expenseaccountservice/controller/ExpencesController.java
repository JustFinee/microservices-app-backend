package microservicesbackend.expenseaccountservice.controller;

import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Expence;
import microservicesbackend.expenseaccountservice.service.ExpenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;


import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

@RestController
public class ExpencesController {

    @Autowired
    ExpenceService expenceService;

    @GetMapping("/getExpences/{userId}")
    public ResponseEntity<List<Expence>> getExpenses(@PathVariable("userId") Long userId, @RequestParam Date from, @RequestParam Date to)
    {
        List<Expence> expences = expenceService.getExpences(userId,from,to);

        if (expences.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(expences,HttpStatus.OK);
    }

    @PostMapping("/createExpence")
    public ResponseEntity<Expence> createExpence(@RequestBody Expence expence)
    {
        Expence created = expenceService.createExpence(expence);
        if (created !=null) return new ResponseEntity<>(created,HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/transfer/{idUser}")
    public ResponseEntity<Expence> transfer(@PathVariable("idUser") Long idUser, @RequestParam Long fromAccountId,
                                            @RequestParam Long toAccountId, @RequestParam double amount, HttpServletResponse response)
    {
        try
        {
            return new ResponseEntity<>(expenceService.transfer(idUser,fromAccountId,toAccountId,amount),HttpStatus.OK);
        }

        catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found id", e);
        }
    }
}
