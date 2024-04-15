package it.esercizi;

public class esercizio1 {
    public static void main(String[] args) {
        int moltiplica = moltiplica(2,3);
        System.out.println(moltiplica);

        String concatena = concatena("Anni ", 10);
        System.out.println(concatena);

        String[] arr = insertIntoArray(new String[]{"A", "B", "C", "D", "E"}, "aaaaa");
        System.out.println(arr);
    }

    public static int moltiplica(int a, int b) {
        return a * b;
    }

    public static String concatena(String a, int b) {
        return a + b;
    }

    public static String[] insertIntoArray(String[] stringArray, String str) {
        String[] array = new String[6];
        for (int i = 0; i < stringArray.length +1 ; i++) {
            if(i < 2) {
                array[i] = stringArray[i];
            } else if(i == 2) {
                array[i] = str;
            } else {
                array[i] = stringArray[i - 1];
            }
        }

        return array;
    }
}
