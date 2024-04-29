package progettosettimanale;
import java.util.Scanner;

public class Riviste extends Catalogo{
    private final Frequenza frequenza;
    private final String titolo;

    public Riviste(String titolo, int numeroPagine, int ISBN, int pubblicazione, Frequenza frequenzaPubblicazione) {
        super(titolo, numeroPagine, ISBN, pubblicazione);
        this.frequenza = frequenzaPubblicazione;
        this.titolo = titolo;
    }

    public Frequenza getFrequenzaPubblicazione() {
        return this.frequenza;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public static Riviste insertMagazines(Scanner sc) {
        System.out.println();
        System.out.println("Write title:");
        String titolo = sc.nextLine();

        Frequenza frequenzaPubblicazione;
        System.out.println("Enter the publication frequency (WEEKLY, MONTHLY, SEMIANNUALLY):");
        do {
            try {
                frequenzaPubblicazione = Frequenza.valueOf(sc.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: invalid publication frequency.");
            }
        } while (true);

        int numeroPagine;
        int pubblicazione;

        System.out.println("Enter the number of pages:");
        numeroPagine = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the publication year:");
        pubblicazione = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the ISBN:");
        int ISBN;
        while (true) {
            if (sc.hasNextInt()) {
                ISBN = sc.nextInt();
                break;
            } else {
                System.err.println("Error: Enter a valid ISBN (must be an integer).");
                sc.nextLine();
            }
        }

        return new Riviste(titolo, numeroPagine, ISBN, pubblicazione, frequenzaPubblicazione);
    }

    @Override
    public String toString() {
        return "\nTipo: Rivista" +
                "\nISBN: " + getISBN() +
                "\nTitle: " + getTitolo() +
                "\nPubblication Date: " + getPubblicazione() +
                "\nNumber Of Page: " + getNumeroPagine() +
                "\nPublication Frequency: " + getFrequenzaPubblicazione() +
                "\n";
    }
}
