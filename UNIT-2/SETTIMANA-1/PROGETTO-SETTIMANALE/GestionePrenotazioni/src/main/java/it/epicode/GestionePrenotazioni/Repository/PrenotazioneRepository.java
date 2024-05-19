package it.epicode.GestionePrenotazioni.Repository;

import it.epicode.GestionePrenotazioni.Bean.Postazione;
import it.epicode.GestionePrenotazioni.Bean.Prenotazione;
import it.epicode.GestionePrenotazioni.Bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
}
