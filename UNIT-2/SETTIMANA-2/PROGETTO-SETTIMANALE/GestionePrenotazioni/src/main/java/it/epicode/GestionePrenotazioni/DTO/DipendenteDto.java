package it.epicode.GestionePrenotazioni.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DipendenteDto {


    private String username;

    @Size(max = 30)
    @NotBlank(message = "Il nome non può essere null o vuoto o solo spazi")
    private String nome;

    @Size(max = 30)
    @NotBlank(message = "Il cognome non può essere null o vuoto o solo spazi")
    private String cognome;


    @Email(message = "L'email inserita non è un indirizzo valido")
    @NotBlank(message = "L'email non può essere null o vuoto o solo spazi")
    private String email;
}