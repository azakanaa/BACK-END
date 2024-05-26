package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
