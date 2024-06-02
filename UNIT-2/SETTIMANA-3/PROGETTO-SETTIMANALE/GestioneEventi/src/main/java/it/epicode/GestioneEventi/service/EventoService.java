package it.epicode.GestioneEventi.service;

import it.epicode.GestioneEventi.dto.EventoDto;
import it.epicode.GestioneEventi.entity.Evento;
import it.epicode.GestioneEventi.entity.Utente;
import it.epicode.GestioneEventi.exception.EventoNonTrovatoException;
import it.epicode.GestioneEventi.exception.NumMaxPartecipantiRaggiunto;
import it.epicode.GestioneEventi.repository.EventoRepository;
import it.epicode.GestioneEventi.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Evento> getAllEventi() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEventoById(int id) {
        return eventoRepository.findById(id);
    }

    public String salvaEvento(EventoDto eventoDto) {
        Evento evento = new Evento();
        evento.setData(eventoDto.getData());
        evento.setTitolo(eventoDto.getTitolo());
        evento.setDescrizione(eventoDto.getDescrizione());
        evento.setMaxPosti(eventoDto.getMaxPosti());
        evento.setLuogo(eventoDto.getLuogo());

        List<Utente> partecipanti = utenteRepository.findByIdIn(eventoDto.getPartecipanti());

        if (partecipanti.size() > evento.getMaxPosti()) {
            throw new NumMaxPartecipantiRaggiunto("Numero massimo di partecipanti è stato raggiunto per questo evento");
        }

        for (Utente partecipante : partecipanti) {
            partecipante.getEventi().add(evento);
        }

        evento.setPartecipanti(partecipanti);
        eventoRepository.save(evento);

        for (Utente partecipante : partecipanti) {
            utenteRepository.save(partecipante);
        }

        evento.setNumeroPostiDisponibili(evento.getMaxPosti() - evento.getPartecipanti().size());

        return "Evento con id: " + evento.getId() + " è stato salvato correttamente";
    }

    public Evento aggiornaEvento(int id, EventoDto eventoDto) {
        Optional<Evento> eventoOptional = getEventoById(id);

        if (eventoOptional.isPresent()) {
            Evento evento = eventoOptional.get();
            evento.setData(eventoDto.getData());
            evento.setLuogo(eventoDto.getLuogo());
            evento.setTitolo(eventoDto.getTitolo());
            evento.setDescrizione(eventoDto.getDescrizione());
            evento.setMaxPosti(eventoDto.getMaxPosti());

            evento.getPartecipanti().clear();

            List<Utente> partecipanti = utenteRepository.findByIdIn(eventoDto.getPartecipanti());

            Set<Utente> utenti = new HashSet<>(partecipanti);

            if (utenti.size() > evento.getMaxPosti()) {
                throw new NumMaxPartecipantiRaggiunto("Numero massimo di partecipanti è stato raggiunto per questo evento");
            }

            for (Utente partecipante : utenti) {
                if (!evento.getPartecipanti().contains(partecipante)) {
                    partecipante.getEventi().add(evento);
                    evento.getPartecipanti().add(partecipante);
                }
            }

            evento.setNumeroPostiDisponibili(evento.getMaxPosti() - evento.getPartecipanti().size());
            eventoRepository.save(evento);

            return evento;
        } else {
            throw new EventoNonTrovatoException("Non è possibile aggiornare, evento non trovato");
        }
    }

    public String eliminaEvento(int id) {
        Optional<Evento> eventoOptional = getEventoById(id);

        if (eventoOptional.isPresent()) {
            eventoRepository.deleteById(id);
            return "Evento con id :" + id + " è stato eliminato";
        } else {
            throw new EventoNonTrovatoException("Evento con id : " + id + " non è stato trovato");
        }
    }
}
