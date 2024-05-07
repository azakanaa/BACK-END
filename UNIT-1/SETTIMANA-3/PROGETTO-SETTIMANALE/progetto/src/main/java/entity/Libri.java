package entity;

import javax.persistence.*;

@Entity
@Table(name = "libri")
public class Libri extends Elemento {

    @Column
    private String autore;

    @Column
    private String genere;

    public Libri(int annoPubblicazione, String titolo, int numeroPagine, String autore, String genere) {
        super(annoPubblicazione, titolo, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libri() {

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codiceISBN=" + getISBN() +
                ", title='" + getTitolo() + '\'' +
                ", anno=" + getAnnoPubblicazione() +
                ", numPagine=" + getNumeroPagine() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
