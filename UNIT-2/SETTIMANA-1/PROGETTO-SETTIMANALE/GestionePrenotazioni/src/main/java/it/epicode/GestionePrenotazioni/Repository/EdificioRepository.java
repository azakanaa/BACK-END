package it.epicode.GestionePrenotazioni.Repository;

import it.epicode.GestionePrenotazioni.Bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
