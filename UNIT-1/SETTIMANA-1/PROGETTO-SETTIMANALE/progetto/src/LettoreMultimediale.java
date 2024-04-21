import java.util.Scanner;

public class LettoreMultimediale {
    public void riproduci() {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] media = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Scegliere il tipo di media. 1: Audio, 2: Video, 3: Immagine ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci titolo: ");
            String titolo = scanner.nextLine();

            switch (scelta) {
                case 1:
                    media[i] = creaAudio(scanner, titolo);
                    break;
                case 2:
                    media[i] = creaVideo(scanner, titolo);
                    break;
                case 3:
                    media[i] = creaImmagine(scanner, titolo);
                    break;
            }
            eseguiMedia(scanner, media);
        }
    }

    private RegistrazioneAudio creaAudio(Scanner scanner, String titolo) {
        System.out.println("Inserisci durata: ");
        int durata = scanner.nextInt();
        System.out.println("Inserisci volume: ");
        int volume = scanner.nextInt();
        return new RegistrazioneAudio(titolo, durata, volume);
    }

    private Video creaVideo(Scanner scanner, String titolo) {
        System.out.println("Inserisci durata: ");
        int durataVideo = scanner.nextInt();
        System.out.println("Inserisci volume: ");
        int volumeVideo = scanner.nextInt();
        System.out.println("Inserisci luminosita: ");
        int luminosita = scanner.nextInt();
        return new Video(titolo, durataVideo, volumeVideo, luminosita);
    }

    private Immagine creaImmagine(Scanner scanner, String titolo) {
        System.out.println("Inserisci luminosità: ");
        int luminositaImmagine = scanner.nextInt();
        return new Immagine(titolo, luminositaImmagine);
    }

    private void eseguiMedia(Scanner scanner, ElementoMultimediale[] media) {
        int scelta;
        do {
            System.out.println("Quale media eseguire (Numero da 1 a 5)? (Inserire 0 per fermare il programma)");
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                media[scelta - 1].esegui();
            } else if (scelta != 0) {
                System.out.println("Scelta non valida, riprova");
            }
        } while (scelta != 0);
    }
}
