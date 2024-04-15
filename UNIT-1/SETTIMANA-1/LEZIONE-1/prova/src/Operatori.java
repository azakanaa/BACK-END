import java.util.Scanner;

public class Operatori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero");
        int x = scanner.nextInt();
        System.out.println("Inserisci un altro numero");
        int y = scanner.nextInt();

        int z = x%y;

        scanner.nextLine();

        System.out.println("Inserisci una parola");
        String s = scanner.nextLine();

        System.out.println(s);

        x++; //x=x+1
        System.out.println(x);
    }

    public static int somma(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void concatena(String s, int a) {
        System.out.println(s+a);
    }
}
