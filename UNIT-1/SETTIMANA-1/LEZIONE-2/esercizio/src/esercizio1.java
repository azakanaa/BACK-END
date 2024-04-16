import java.util.Scanner;

public class esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una parola");
        String parola = scanner.nextLine();
        stringaPariDispari(parola);

        System.out.println("Inserisci un anno");
        int anno = scanner.nextInt();
        annoBisestile(anno);
    }

    public static void stringaPariDispari(String numCaratteri){

        if(numCaratteri.length()%2==0){
            System.out.println("Le lettere sono di numero pari");
        } else {
            System.out.println("Le lettere sono dispari");
        }
    }

    public static void annoBisestile(int anno){
        boolean divisibilePer4 = (anno % 4 == 0);
        boolean divisibilePer100 = (anno % 100 == 0);
        boolean divisibilePer400 = (anno % 400 == 0);
        boolean bisestile = divisibilePer4 && (!divisibilePer100 || divisibilePer400);
        if (bisestile)
            System.out.println("L'anno " + anno + " è bisestile");
        else
            System.out.println("L'anno " + anno + " NON è bisestile");
    }
}
