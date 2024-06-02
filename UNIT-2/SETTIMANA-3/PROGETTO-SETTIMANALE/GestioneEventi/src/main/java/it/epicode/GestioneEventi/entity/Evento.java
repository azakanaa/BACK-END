package it.epicode.GestioneEventi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int maxPosti;
    private int numeroPostiDisponibili;

    @ManyToMany(mappedBy = "eventi")
    private List<Utente> partecipanti = new ArrayList<>();
}
