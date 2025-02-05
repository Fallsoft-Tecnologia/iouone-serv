package br.com.iouone;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableRabbit
@EnableFeignClients
public class IouoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(IouoneApplication.class, args);
	}

}
