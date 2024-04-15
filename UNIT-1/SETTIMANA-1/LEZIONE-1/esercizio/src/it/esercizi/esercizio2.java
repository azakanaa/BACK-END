package it.esercizi;

import java.util.Scanner;

public class esercizio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la prima parola");
        String prima = scanner.nextLine();
        System.out.println("Inserisci la seconda parola");
        String seconda = scanner.nextLine();
        System.out.println("Inserisci la terza parola");
        String terza = scanner.nextLine();

        String frase = prima + " " + seconda + " " + terza;
        System.out.println(frase);
        String fraseInversa = terza + " " + seconda + " " + prima;
        System.out.println(fraseInversa);
    }
}
