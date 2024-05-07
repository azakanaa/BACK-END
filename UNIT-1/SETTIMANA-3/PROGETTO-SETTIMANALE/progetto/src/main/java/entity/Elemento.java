package entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "elementi")
public class Elemento {
    @Id
    @GeneratedValue
    private UUID ISBN;

    @Column(length = 30)
    private String titolo;

    @Column (name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column (name = "numero_pagine")
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;

    public Elemento(int annoPubblicazione, String titolo, int numeroPagine) {
        this.annoPubblicazione = annoPubblicazione;
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
    }

    public Elemento() {

    }


    public UUID getISBN() {
        return ISBN;
    }

    public void setISBN(UUID ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
