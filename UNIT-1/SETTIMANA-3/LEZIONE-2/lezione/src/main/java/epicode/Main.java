package epicode;
import epicode.dao.StudenteDao;
import epicode.entity.Indirizzo;
import epicode.entity.Studente;
import epicode.entity.TipoStudente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);

        Studente s1 = new Studente();
        s1.setNome("Rino");
        s1.setCognome("De Martino");
//        s1.setIndirizzo("Via Dei Mille");
        s1.setDataNascita(LocalDate.of(2000, 8, 23));
        s1.setTipoStudente(TipoStudente.FULL_TIME);

        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia("Via dei Mille");
        indirizzo.setComune("Salerno");
        indirizzo.setProvincia("SA");

        dao.save(s1);

//        Studente s2 = dao.getById(1);
//        System.out.println(s2);

//        s2.setIndirizzo("Via Dei Greci");

        //dao.save(s2);
        //ha verificato se già esisteva + lo ha aggiornato xk già esisteva +
        //flush = portato le modifiche dal persistent context al database, quindi ha fatto la modifica

//        dao.delete(s2);
    }
}
