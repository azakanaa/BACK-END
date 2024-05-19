package it.epicode.GestionePrenotazioni.Repository;

import it.epicode.GestionePrenotazioni.Bean.Postazione;
import it.epicode.GestionePrenotazioni.Enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    @Query("SELECT p from Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    List<Postazione> cercaPostazioniPerTipoECitta(Tipo tipo, String citta);
}
