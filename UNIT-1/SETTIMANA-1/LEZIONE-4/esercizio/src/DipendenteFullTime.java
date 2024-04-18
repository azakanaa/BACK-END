public class DipendenteFullTime extends Dipendente implements checkIn {
    private double stipendioFisso;

    public DipendenteFullTime(String matricola, Dipartimento dipartimento, double stipendioFisso) {
        super(matricola, dipartimento);
        this.stipendioFisso = stipendioFisso;
    }

    public double getStipendioFisso() {
        return stipendioFisso;
    }

    public void setStipendioFisso(double stipendioFisso) {
        this.stipendioFisso = stipendioFisso;
    }

    public double calculateSalary(){
        return stipendioFisso;
    }

    @Override
    public void orarioServizio(){
        System.out.println("Inizia il servizio alle: 8:00");
    }

}
