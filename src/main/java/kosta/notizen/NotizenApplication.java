package kosta.notizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indicates that this is a Spring Boot application and enables auto-configuration
@SpringBootApplication 
public class NotizenApplication {

	public static void main(String[] args) {
		// Launches the Spring Boot application
		SpringApplication.run(NotizenApplication.class, args);
	}

}
