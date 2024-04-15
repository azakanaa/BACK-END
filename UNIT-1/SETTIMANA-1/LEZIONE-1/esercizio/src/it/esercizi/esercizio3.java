package it.esercizi;

import java.util.Scanner;

public class esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un lato");
        double l1 = scanner.nextDouble();
        System.out.println("Inserisci il secondo lato");
        double l2 = scanner.nextDouble();
        System.out.println("Il perimetro è: " + perimetroRettangolo(l1, l2));

        System.out.println("Inserisci un numero");
        int numero = scanner.nextInt();
        System.out.println("0 se pari, 1 se dispari: " + pariDispari(numero));

        System.out.println("Inserisci un lato");
        double a = scanner.nextDouble();
        System.out.println("Inserisci un lato");
        double b = scanner.nextDouble();
        System.out.println("Inserisci un lato");
        double c = scanner.nextDouble();
        System.out.println("Perimetro del triangolo: " + perimetroTriangolo(a, b, c));

        System.out.println("Area del triangolo: " + areaTriangolo(a, b, c));
    }
    public static double perimetroRettangolo(double l1, double l2){
        return l1 + l2 + l1 + l2;
    }
    public static int pariDispari(int a){
        return a % 2;
    }
    public static double perimetroTriangolo(double a, double b, double c){
        return (a+b+c)/2;
    }
    public static double areaTriangolo(double a, double b, double c){
        return Math.sqrt(
                (perimetroTriangolo(a, b, c)*(perimetroTriangolo(a, b, c)-a)*(perimetroTriangolo(a, b, c)-b)*(perimetroTriangolo(a, b, c)-c))
        );
    }
}
