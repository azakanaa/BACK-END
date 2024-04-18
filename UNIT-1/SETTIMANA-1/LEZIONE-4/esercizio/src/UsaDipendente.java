public class UsaDipendente {
    public static void main(String[] args) {
//        Dipendente[] dipendente = new Dipendente[3];
//
//        dipendente[0] = new Dipendente("A123456", 1200.5, Dipartimento.PRODUZIONE);
//        dipendente[1] = new Dipendente("B123456", 3400.2, Dipartimento.AMMINISTRAZIONE);
//        dipendente[2] = new Dipendente("C123456", 2500.3, Dipartimento.VENDITE);
//
//        for (int i = 0; i < dipendente.length; i++){
//            System.out.println(dipendente[i].getMatricola());
//        }

        DipendenteFullTime[] fullTimes = new DipendenteFullTime[2];

        fullTimes[0] = new DipendenteFullTime("FT111111", Dipartimento.AMMINISTRAZIONE, 3400.0);
        fullTimes[1] = new DipendenteFullTime("FT222222", Dipartimento.PRODUZIONE, 2400.0);

        for (int i = 0; i < fullTimes.length; i++){
            System.out.println("Matricola " + fullTimes[i].getMatricola());
            fullTimes[i].orarioServizio();
        }

        DipendentePartTime[] partTimes = new DipendentePartTime[2];

        partTimes[0] = new DipendentePartTime("PT111111", Dipartimento.VENDITE, 20, 9);
        partTimes[1] = new DipendentePartTime("PT222222", Dipartimento.VENDITE, 30, 9);

        for (int i = 0; i < partTimes.length; i++){
            System.out.println("Matricola " + partTimes[i].getMatricola());
            partTimes[i].orarioServizio();
        }

        Volontario[] volontario = new Volontario[3];

        volontario[0] = new Volontario("V111111", Dipartimento.PRODUZIONE, "Gennaro", 20, "CV1");
        volontario[1] = new Volontario("V222222", Dipartimento.PRODUZIONE, "Marina", 34, "CV2");
        volontario[2] = new Volontario("V333333", Dipartimento.PRODUZIONE, "Alex", 25, "CV");

        for (int i = 0; i < volontario.length; i++){
            System.out.println("Matricola " + volontario[i].getMatricola());
            volontario[i].orarioServizio();
        }

    }
}
