package it.epicode.GestionePrenotazioni.DTO;

import it.epicode.GestionePrenotazioni.enumType.StatoDispositivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComputerDto {

    @NotNull(message = "Lo stato del dispositivo non può essere null")
    private StatoDispositivo stato;


    private int dipendenteId;

    @NotBlank(message = "Il modello non può essere null o vuoto o solo spazi")
    private String modello;

    @NotNull(message = "La memoria non può essere null ")
    private int memoria;
}