package com.noxtec.agendamentotelefonico;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.noxtec.agendamentotelefonico.entities" })
@EnableJpaRepositories(basePackages = { "com.noxtec.agendamentotelefonico.repositories" })
@ComponentScan(basePackages = {"com.noxtec.agendamentotelefonico.controllers"})
public class AgendamentoTelefonicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoTelefonicoApplication.class, args);
	}

}
