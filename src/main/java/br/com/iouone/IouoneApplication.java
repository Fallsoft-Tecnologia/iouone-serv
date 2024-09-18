package br.com.iouone;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class IouoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(IouoneApplication.class, args);
	}

}
