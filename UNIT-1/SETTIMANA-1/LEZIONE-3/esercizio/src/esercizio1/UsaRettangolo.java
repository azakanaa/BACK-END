package esercizio1;

public class UsaRettangolo {

    public static void main(String[] args) {
        //primo rettangolo
        Rettangolo rettangolo = new Rettangolo(4,5);

        System.out.println("Il valore dell'altezza è: " + rettangolo.getAltezza());
        System.out.println("Il valore della larghezza è: " + rettangolo.getLarghezza());

        int risultatoPerimetro = rettangolo.perimetroRettangolo(4, 5);

        System.out.println("Il perimetro misura: " + risultatoPerimetro);

        int risultatoArea = rettangolo.areaRettangolo(4, 5);

        System.out.println("L'area misura: " + risultatoArea);

        //secondo rettangolo
        Rettangolo rettangolo2 = new Rettangolo(3, 5);
        System.out.println("Il valore dell'altezza è: " + rettangolo2.getAltezza());
        System.out.println("Il valore della larghezza è: " + rettangolo2.getLarghezza());

        int risultatoPerimetro2 = rettangolo2.perimetroRettangolo(3, 5);

        System.out.println("Il perimetro misura: " + risultatoPerimetro2);

        int risultatoArea2 = rettangolo2.areaRettangolo(3, 5);
        System.out.println("L'area misura: " + risultatoArea2);

        int sommaPerimetri = risultatoPerimetro + risultatoPerimetro2;
        System.out.println("Somma dei perimetri: " + sommaPerimetri);

        int sommaAree = risultatoArea + risultatoArea2;
        System.out.println("Somma delle aree: " + sommaAree);
    }
}
