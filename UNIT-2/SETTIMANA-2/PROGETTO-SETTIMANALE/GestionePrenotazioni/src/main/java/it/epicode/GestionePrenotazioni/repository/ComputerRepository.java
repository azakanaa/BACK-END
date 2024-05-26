package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}