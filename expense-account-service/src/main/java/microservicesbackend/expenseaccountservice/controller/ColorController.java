package microservicesbackend.expenseaccountservice.controller;

import microservicesbackend.expenseaccountservice.entity.Color;
import microservicesbackend.expenseaccountservice.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping("/getAllColors")
    public ResponseEntity<List<Color>> getAllColors() {
        return new ResponseEntity<>(colorService.getAllColors(), HttpStatus.OK);
    }
}
