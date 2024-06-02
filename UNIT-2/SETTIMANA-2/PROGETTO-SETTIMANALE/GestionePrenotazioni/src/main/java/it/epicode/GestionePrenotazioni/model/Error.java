package it.epicode.GestionePrenotazioni.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class Error {

    private String message;
    private LocalDateTime dataErrore;
    private HttpStatus statoErrore;

}