public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.print(titolo + ": ");
            for (int j = 0; j < volume; j++) {
                System.out.print("!");
            }
            System.out.println();
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    @Override
    public void esegui() {
        play();
    }
}
