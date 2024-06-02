package it.epicode.GestioneEventi.controller;

import it.epicode.GestioneEventi.dto.EventoDto;
import it.epicode.GestioneEventi.entity.Evento;
import it.epicode.GestioneEventi.exception.BadRequestException;
import it.epicode.GestioneEventi.exception.UtenteNonTrovatoException;
import it.epicode.GestioneEventi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventi")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public List<Evento> getAllEvento() {
        return eventoService.getAllEventi();
    }

    @GetMapping("/eventi/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public Evento getEventoById(@PathVariable int id) {
        Optional<Evento> eventoOptional = eventoService.getEventoById(id);
        if (eventoOptional.isPresent()) {
            return eventoOptional.get();
        } else {
            throw new UtenteNonTrovatoException("Evento con id : " + id + " non è stato trovato");
        }
    }

    @PostMapping("/eventi")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public String salvaEvento(@RequestBody EventoDto eventoDto) {
        return eventoService.salvaEvento(eventoDto);
    }

    @PutMapping("/eventi/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Evento aggiornaEvento(@PathVariable int id, @RequestBody @Validated EventoDto eventoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return eventoService.aggiornaEvento(id, eventoDto);
    }

    @DeleteMapping("/eventi/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public String eliminaEvento(@PathVariable int id) {
        return eventoService.eliminaEvento(id);
    }

}
