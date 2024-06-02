package it.epicode.GestioneEventi.service;

import it.epicode.GestioneEventi.dto.UtenteLoginDto;
import it.epicode.GestioneEventi.entity.Utente;
import it.epicode.GestioneEventi.exception.UnauthorizedException;
import it.epicode.GestioneEventi.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserandCreateToken(UtenteLoginDto utenteLoginDto) {
        Utente utente = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());

        if(passwordEncoder.matches(utenteLoginDto.getPassword(), utente.getPassword())) {
            return jwtTool.createToken(utente);
        } else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }
    }
}
