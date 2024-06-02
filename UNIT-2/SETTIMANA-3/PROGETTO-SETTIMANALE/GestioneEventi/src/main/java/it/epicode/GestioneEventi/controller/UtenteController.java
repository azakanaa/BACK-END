package it.epicode.GestioneEventi.controller;

import it.epicode.GestioneEventi.dto.UtenteDto;
import it.epicode.GestioneEventi.entity.Utente;
import it.epicode.GestioneEventi.exception.BadRequestException;
import it.epicode.GestioneEventi.exception.UtenteNonTrovatoException;
import it.epicode.GestioneEventi.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping("/utenti")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public List<Utente> getAllUtenti() {
        return utenteService.getAllUtenti();
    }

    @GetMapping("/utenti/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public Utente getUtenteById (@PathVariable int id) {
        Optional<Utente> userOptional = utenteService.getUtenteById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UtenteNonTrovatoException("Utente con id: " + id + " non è stato trovato");
        }
    }

    @PutMapping("/utenti/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public Utente aggiornaUtente (@PathVariable int id, @RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return utenteService.aggiornaUtente(id, utenteDto);
    }

    @DeleteMapping("/utenti/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE','ORGANIZZATORE')")
    public String eliminaUtente (@PathVariable int id) {
        return utenteService.eliminaUtente(id);
    }
}
