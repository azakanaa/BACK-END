package esercizio1;

public class Rettangolo {

    private int altezza;
    private int larghezza;

    public Rettangolo(int altezza, int larghezza){
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int perimetroRettangolo(int altezza, int larghezza){
        return (altezza*2)+(larghezza*2);
    }

    public int areaRettangolo(int altezza, int larghezza){
        return altezza * larghezza;
    }
}
