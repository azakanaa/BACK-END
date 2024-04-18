public class DipendentePartTime extends Dipendente implements checkIn {

    private double oreLavorate;
    private double euroPerOra;

    public DipendentePartTime(String matricola, Dipartimento dipartimento, double oreLavorate, double euroPerOra) {
        super(matricola, dipartimento);
        this.oreLavorate = oreLavorate;
        this.euroPerOra = euroPerOra;
    }

    public double getOreLavorate() {
        return oreLavorate;
    }

    public void setOreLavorate(double oreLavorate) {
        this.oreLavorate = oreLavorate;
    }

    public double getEuroPerOra() {
        return euroPerOra;
    }

    public double calcolaSalario(){
        return oreLavorate*euroPerOra;
    }
    @Override
    public void orarioServizio(){
        System.out.println("Inizio il servizio alle: 10:00");
    }

}

