package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
}
