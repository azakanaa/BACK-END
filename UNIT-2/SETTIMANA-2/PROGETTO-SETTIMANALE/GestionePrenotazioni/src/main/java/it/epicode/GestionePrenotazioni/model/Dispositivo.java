package it.epicode.GestionePrenotazioni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.GestionePrenotazioni.enumType.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;

}
