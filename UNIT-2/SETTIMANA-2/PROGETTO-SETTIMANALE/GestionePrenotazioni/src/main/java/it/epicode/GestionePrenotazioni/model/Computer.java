package it.epicode.GestionePrenotazioni.model;

import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
public class Computer extends Dispositivo{

    private String modello;
    private int memoria;

}