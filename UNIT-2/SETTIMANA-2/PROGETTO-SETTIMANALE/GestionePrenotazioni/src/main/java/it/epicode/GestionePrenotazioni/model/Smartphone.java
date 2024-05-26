package it.epicode.GestionePrenotazioni.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Smartphone extends Dispositivo {

    private String modello;
    private int memoria;

}