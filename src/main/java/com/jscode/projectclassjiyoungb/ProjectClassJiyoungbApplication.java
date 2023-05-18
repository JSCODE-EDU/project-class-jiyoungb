package com.jscode.projectclassjiyoungb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectClassJiyoungbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectClassJiyoungbApplication.class, args);
	}

}
