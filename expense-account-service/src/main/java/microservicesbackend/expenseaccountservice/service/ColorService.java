package microservicesbackend.expenseaccountservice.service;

import com.netflix.discovery.converters.Auto;
import microservicesbackend.expenseaccountservice.entity.Color;
import microservicesbackend.expenseaccountservice.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> getAllColors(){
        return colorRepository.findAll();
    }
}
