package com.seguritech.MiPracticaFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.seguritech.MiPracticaFinal.domain.repositories")
public class MiPracticaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPracticaFinalApplication.class, args);
	}
}
