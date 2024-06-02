package it.epicode.GestioneEventi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteDto {
    @NotBlank(message = "nome non può essere vuoto o null o con soli spazi")
    private String nome;

    @NotBlank(message = "cognome non può essere vuoto o null o con soli spazi")
    private String cognome;

    @Email
    @NotBlank(message = "email non può essere vuoto o null o con soli spazi")
    private String email;

    @NotBlank(message = "password non può essere vuoto o null o con soli spazi")
    private String password;
}
