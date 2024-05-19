package it.epicode.GestionePrenotazioni.Service;

import it.epicode.GestionePrenotazioni.Bean.Utente;
import it.epicode.GestionePrenotazioni.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void inserisciUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public void eliminaUtente(int id) {
        utenteRepository.deleteById(id);
    }

    public Utente getUtenteById(int id) {
        return utenteRepository.findById(id).get();
    }
}
