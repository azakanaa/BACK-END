package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.Bean.Edificio;
import it.epicode.GestionePrenotazioni.Bean.Postazione;
import it.epicode.GestionePrenotazioni.Bean.Prenotazione;
import it.epicode.GestionePrenotazioni.Bean.Utente;
import it.epicode.GestionePrenotazioni.Enums.Tipo;
import it.epicode.GestionePrenotazioni.Service.EdificioService;
import it.epicode.GestionePrenotazioni.Service.PostazioneService;
import it.epicode.GestionePrenotazioni.Service.PrenotazioneService;
import it.epicode.GestionePrenotazioni.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {

//        //ACCEDO AL CONTESTO
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
//
//        //INSERISCO EDIFICIO NEL DB
//        Edificio e = ctx.getBean("edificio", Edificio.class);
//        edificioService.inserisciEdificio(e);
//
//        //INSERISCO POSTAZIONE NEL DB
//        Postazione p = ctx.getBean("postazione", Postazione.class);
//        postazioneService.inserisciPostazione(p);
//
//        //INSERISCO UTENTE NEL DB
//        Utente u = ctx.getBean("Elena", Utente.class);
//        utenteService.inserisciUtente(u);

        // INSERISCO PRENOTAZIONE NEL DB
//        Prenotazione prenotazione = new Prenotazione();
//        prenotazione.setPostazione(postazioneService.getPostazioneById(1));
//        prenotazione.setUtente(utenteService.getUtenteById(1));
//        prenotazione.setData(LocalDate.of(2024,05,17));
//        prenotazioneService.inserisciPrenotazione(prenotazione);


        // PROVA PER CONFERMARE CHE L'UTENTE HA GIà LA PRENOTAZIONE PER QUESTO GIORNO
//        Prenotazione prenotazione = new Prenotazione();
//        prenotazione.setPostazione(postazioneService.getPostazioneById(1));
//        prenotazione.setUtente(utenteService.getUtenteById(1));
//        prenotazione.setData(LocalDate.of(2024,05,17));
//        prenotazioneService.inserisciPrenotazione(prenotazione);


        // RICERCA PER TROVARE UNA POSTAZIONE TRAMITE TIPO E CITTà
        postazioneService.ricercaPostazioniPerTipoECitta(Tipo.OPENSPACE, "Cava de' Tirreni").forEach(System.out::println);
    }
}
