import java.util.Scanner;

public class esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una parola da smontare");
        String parola = scanner.nextLine();

        char i = 0;

        do {
            System.out.println(parola.charAt(i));

            i++;
            if(parola.equals("q")){
                break;
            }
        } while(i <= parola.length());
    }
}
