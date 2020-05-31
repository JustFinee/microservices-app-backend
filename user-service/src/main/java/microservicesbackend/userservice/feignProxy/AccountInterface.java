package microservicesbackend.userservice.feignProxy;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "expence-account-service", url="localhost:9200")
public interface AccountInterface {

    @PostMapping("/createInvisibleAccount/{idUser}")
    public void createInvisibleAccount(@PathVariable("idUser") Long idUser);
}
