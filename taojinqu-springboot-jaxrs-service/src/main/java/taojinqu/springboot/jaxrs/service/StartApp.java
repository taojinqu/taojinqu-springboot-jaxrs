package taojinqu.springboot.jaxrs.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "taojinqu.springboot.jaxrs.service")
public class StartApp extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
