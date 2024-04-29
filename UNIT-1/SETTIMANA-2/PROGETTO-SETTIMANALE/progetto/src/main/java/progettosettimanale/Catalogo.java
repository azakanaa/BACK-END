package progettosettimanale;

import java.io.Serializable;

public class Catalogo implements Serializable {
    private String titolo;
    private int numeroPagine;
    private int ISBN;
    private int pubblicazione;

    public Catalogo() {}

    public Catalogo(String titolo, int numeroPagine, int ISBN, int pubblicazione) {
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.ISBN = ISBN;
        this.pubblicazione = pubblicazione;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public int getNumeroPagine() {
        return this.numeroPagine;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public int getPubblicazione() {
        return this.pubblicazione;
    }
}
