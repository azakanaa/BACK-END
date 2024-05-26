package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
}