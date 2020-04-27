package microservicesbackend.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/findUser/{email}")
    public Optional<User> findUser(@PathVariable(name = "email") String email)
    {
        return userRepository.findByEmail(email);
    }
}
