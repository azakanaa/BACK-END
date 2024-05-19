package it.epicode.GestionePrenotazioni.Repository;

import it.epicode.GestionePrenotazioni.Bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
