package org.andrianb.suntehnic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories
@SpringBootApplication
public class SuntehnicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuntehnicApplication.class, args);
	}
}
