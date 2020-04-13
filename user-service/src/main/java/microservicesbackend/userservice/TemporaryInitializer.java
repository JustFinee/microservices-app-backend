package microservicesbackend.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;


@Component
public class TemporaryInitializer {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initializeDB(){
        return (args -> {
           List<User> users = userRepository.findAll();

           if (users.isEmpty()){
               this.userRepository.save(new User("bbzietek215@gmail.com","Bartek", "123laptop", Arrays.asList("USER","ADMIN")));
           }
        });
    }
}
