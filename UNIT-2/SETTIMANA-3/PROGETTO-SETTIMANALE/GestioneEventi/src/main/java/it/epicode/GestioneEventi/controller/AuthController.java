package it.epicode.GestioneEventi.controller;

import it.epicode.GestioneEventi.dto.UtenteDto;
import it.epicode.GestioneEventi.dto.UtenteLoginDto;
import it.epicode.GestioneEventi.exception.BadRequestException;
import it.epicode.GestioneEventi.service.AuthService;
import it.epicode.GestioneEventi.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public String register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        utenteService.salvaUtente(utenteDto);
        return "Utente è stato salvato correttamente";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated UtenteLoginDto utenteLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return authService.authenticateUserandCreateToken(utenteLoginDto);
    }
}
