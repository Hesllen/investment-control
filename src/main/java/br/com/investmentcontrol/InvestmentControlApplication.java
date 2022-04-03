package br.com.investmentcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InvestmentControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentControlApplication.class, args);
	}

}
