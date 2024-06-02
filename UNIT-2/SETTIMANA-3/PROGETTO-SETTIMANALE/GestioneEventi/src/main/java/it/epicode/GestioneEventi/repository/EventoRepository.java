package it.epicode.GestioneEventi.repository;

import it.epicode.GestioneEventi.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
