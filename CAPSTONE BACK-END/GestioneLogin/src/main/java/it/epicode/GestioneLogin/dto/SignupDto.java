package it.epicode.GestioneLogin.dto;

import it.epicode.GestioneLogin.entity.Utente;
import lombok.Data;

@Data
public class SignupDto {
    private Utente utente;
}
