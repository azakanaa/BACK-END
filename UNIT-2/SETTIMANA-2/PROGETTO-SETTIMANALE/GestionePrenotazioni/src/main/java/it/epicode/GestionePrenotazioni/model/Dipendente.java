package it.epicode.GestionePrenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String fotoProfilo;

    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi;
}