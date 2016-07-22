package taojinqu.springboot.jaxrs.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "taojinqu.springboot.jaxrs.service")
public class StartApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
