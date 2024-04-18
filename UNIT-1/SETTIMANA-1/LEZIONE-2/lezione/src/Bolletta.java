import java.util.Scanner;

public class Bolletta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il consumo d'acqua");
        int consumo = scanner.nextInt();

        if (consumo <= 100){
            double bolletta = 20 + 2.5*consumo;
            System.out.println(bolletta);
        }
        else {
            double bolletta = 20 + 250 + 4*(consumo-100);
            System.out.println(bolletta);
        }


    }
}
