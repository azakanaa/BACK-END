package entity;

import javax.persistence.*;

@Entity
@Table (name = "riviste")
public class Riviste extends Elemento {

    @Column
    private Periodicita periodicita;


    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    public Riviste(int annoPubblicazione, String titolo, int numeroPagine, Periodicita periodicita) {
        super(annoPubblicazione, titolo, numeroPagine);
        this.periodicita = periodicita;
    }

    public Riviste () {

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "codiceISBN=" + getISBN() +
                ", title='" + getTitolo() + '\'' +
                ", anno=" + getAnnoPubblicazione() +
                ", numPagine=" + getNumeroPagine() +
                "periodicita=" + periodicita +
                '}';
    }
}