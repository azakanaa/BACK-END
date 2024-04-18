public class Dirigente extends Dipendente {

    private double stipendioFisso;

    public Dirigente(String matricola, Dipartimento dipartimento, double stipendioFisso) {
        super(matricola, dipartimento);
        this.stipendioFisso = stipendioFisso;
    }

    public double calcolaSalario(){
        return stipendioFisso;
    }
}
