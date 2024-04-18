public class Volontario extends Dipendente implements checkIn {
    private String nome;
    private int eta;
    private String curriculum;

    public Volontario(String matricola, Dipartimento dipartimento, String nome, int eta, String curriculum) {
        super(matricola, dipartimento);
        this.nome = nome;
        this.eta = eta;
        this.curriculum = curriculum;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public String getCurriculum() {
        return curriculum;
    }

    @Override
    public void orarioServizio(){
        System.out.println("Inizia il servizio alle: 9:00");
    }
}
