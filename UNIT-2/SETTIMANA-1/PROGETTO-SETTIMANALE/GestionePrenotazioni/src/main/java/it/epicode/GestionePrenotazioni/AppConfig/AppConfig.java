package it.epicode.GestionePrenotazioni.AppConfig;

import it.epicode.GestionePrenotazioni.Bean.Edificio;
import it.epicode.GestionePrenotazioni.Bean.Postazione;
import it.epicode.GestionePrenotazioni.Bean.Utente;
import it.epicode.GestionePrenotazioni.Enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean(name = "edificio")
    public Edificio getEdificio() {
        Edificio edificio = new Edificio();
        edificio.setNome("Primo Edificio");
        edificio.setCitta("Cava de' Tirreni");
        edificio.setIndirizzo("Via Vittorio Emanuele");
        return edificio;
    }

    @Bean(name = "postazione")
    public Postazione getPostazione() {
        Postazione postazione = new Postazione();
        postazione.setTipo(Tipo.OPENSPACE);
        postazione.setDescrizione("Evento di tipo OpenSpace");
        postazione.setEdificio(getEdificio());
        postazione.setNumMaxOccupantiEdificio(5);
        return postazione;
    }

    @Bean(name = "Sabine")
    public Utente getUtente1() {
        Utente utente = new Utente();
        utente.setUsername("viper");
        utente.setEmail("sabinecallas@hotmail.com");
        utente.setNomeCompleto("Sabine Callas");
        return utente;
    }
}
