package it.epicode.GestionePrenotazioni.controller;

import it.epicode.GestionePrenotazioni.DTO.DipendenteDto;
import it.epicode.GestionePrenotazioni.exception.BadRequestException;
import it.epicode.GestionePrenotazioni.exception.DipendenteNonTrovatoException;
import it.epicode.GestionePrenotazioni.model.Dipendente;
import it.epicode.GestionePrenotazioni.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/api/dipendenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("/api/dipendenti")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "1") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getAllDipendenti(page, size, sortBy);
    }

    @GetMapping("/api/dipendenti/{id}")
    public Dipendente getDipendenteById(@PathVariable int id) {
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteeById(id);

        if (dipendenteOptional.isPresent()) {
            return dipendenteOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con ID " + id + " non è stato trovato");
        }
    }

    @PutMapping("/api/dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente updateDipendente(@PathVariable int id,
                                       @RequestBody @Validated DipendenteDto dipendenteDto,
                                       BindingResult bindingResult) throws BadRequestException {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/api/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/api/dipendenti/{id}")
    public String patchFoto(@PathVariable int id, @RequestBody MultipartFile foto) throws IOException {
        return dipendenteService.patchFoto(id, foto);
    }
}
