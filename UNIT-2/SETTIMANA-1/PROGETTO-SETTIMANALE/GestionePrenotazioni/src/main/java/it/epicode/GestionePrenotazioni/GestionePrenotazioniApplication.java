package it.epicode.GestionePrenotazioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "it.epicode.GestionePrenotazioni")
@EnableJpaRepositories(basePackages = "it.epicode.GestionePrenotazioni.Repository")
@EntityScan(basePackages = "it.epicode.GestionePrenotazioni.Bean")
public class GestionePrenotazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

}
