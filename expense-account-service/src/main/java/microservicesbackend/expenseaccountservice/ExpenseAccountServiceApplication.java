package microservicesbackend.expenseaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ExpenseAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseAccountServiceApplication.class, args);
	}

}
