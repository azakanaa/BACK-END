package it.epicode.GestioneEventi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteLoginDto {
    @Email
    @NotBlank(message = "email non può essere vuoto o mancante o composto da soli spazi")
    private String email;
    @NotBlank(message = "password non può essere vuoto o mancante o composto da soli spazi")
    private String password;
}
