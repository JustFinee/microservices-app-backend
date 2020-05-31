package microservicesbackend.expenseaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ExpenseAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseAccountServiceApplication.class, args);
	}

}
