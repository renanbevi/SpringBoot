package com.aulajava.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@org.springframework.boot.autoconfigure.SpringBootApplication
@EntityScan(basePackages = "curso.springboot.model") // Vareu o pacote procurando as entidades
@EnableJpaRepositories(basePackages = "com.aulajava.springboot.repository") //Passando o pacote repository
@EnableTransactionManagement //como vamos utilizar toda a persistencia do spring boot podemos habilitar a parte de transação.

public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
