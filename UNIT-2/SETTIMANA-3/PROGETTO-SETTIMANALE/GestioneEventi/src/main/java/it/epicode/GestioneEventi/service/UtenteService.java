package it.epicode.GestioneEventi.service;

import it.epicode.GestioneEventi.dto.UtenteDto;
import it.epicode.GestioneEventi.entity.Ruolo;
import it.epicode.GestioneEventi.entity.Utente;
import it.epicode.GestioneEventi.exception.UtenteNonTrovatoException;
import it.epicode.GestioneEventi.repository.EventoRepository;
import it.epicode.GestioneEventi.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUtenteById(int id) {
        return utenteRepository.findById(id);
    }

    public Utente getUtenteByEmail(String email) {
        Optional<Utente> utenteOptional = utenteRepository.findByEmail(email);

        if (utenteOptional.isPresent()) {
            return utenteOptional.get();
        } else {
            throw new UtenteNonTrovatoException("Utente con email: " + email + " non è stato trovato");
        }
    }

    public String salvaUtente(UtenteDto utenteDto) {
        Utente utente = new Utente();
        utente.setEmail(utenteDto.getEmail());
        utente.setNome(utenteDto.getNome());
        utente.setCognome(utenteDto.getCognome());

        utente.setRuolo(Ruolo.UTENTE);

        utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
        utenteRepository.save(utente);

        return "Utente con id: " + utente.getId() + " è stato salvato correttamente";
    }

    public Utente aggiornaUtente(int id, UtenteDto utenteDto) {
        Optional<Utente> utenteOptional = getUtenteById(id);

        if (utenteOptional.isPresent()) {
            Utente utente = utenteOptional.get();
            utente.setEmail(utenteDto.getEmail());
            utente.setNome(utenteDto.getNome());
            utente.setCognome(utenteDto.getCognome());

            utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));

            return utenteRepository.save(utente);
        } else {
            throw new UtenteNonTrovatoException("Non è possibile aggiornare, utente non trovato");
        }
    }

    public String eliminaUtente(int id) {
        Optional<Utente> utenteOptional = getUtenteById(id);

        if (utenteOptional.isPresent()) {
            utenteRepository.deleteById(id);
            return "Utente con id: " + id + " è stato eliminato";
        } else {
            throw new UtenteNonTrovatoException("Utente con id: " + id + " non è stato trovato");
        }
    }
}
