package sk.fzdp.ciphers.reciprocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="sk.fzdp.ciphers.reciprocal")
public class ReciprocalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciprocalApplication.class, args);
	}

}
