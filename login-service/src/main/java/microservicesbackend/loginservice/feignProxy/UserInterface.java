package microservicesbackend.loginservice.feignProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service", url="localhost:9100")
public interface UserInterface {

    @GetMapping("/findUser/{email}")
    public UserDto findUser(@PathVariable(name = "email") String email);
}
