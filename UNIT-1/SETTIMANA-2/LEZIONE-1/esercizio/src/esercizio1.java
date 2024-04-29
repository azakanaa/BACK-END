import java.util.Random;
import java.util.Scanner;

public class esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeri = new int[5];
        for(int i = 0; i < numeri.length; i++){
            numeri[i] = new Random().nextInt(10);
        }
        //for avanzato
        for(int numero: numeri){
            System.out.println(numero);
        }

        inserisciNumeroInArray(numeri);

        for(int numero: numeri){
            System.out.println(numero);
        }
    }

    public static void inserisciNumeroInArray(int[] array){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire numero");
        int numero = scanner.nextInt();

        System.out.println("Inserire posizione");
        int posizione = scanner.nextInt();

        array[posizione] = numero;
    }
}
