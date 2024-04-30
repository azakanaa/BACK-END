package esercizio;

import esercizio.dao.EventoDAO;
import esercizio.entity.Evento;
import esercizio.entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EventoDAO dao = new EventoDAO(em);

        Evento e1 = new Evento();
        e1.setTitolo("Sanremo");
        e1.setDataEvento(LocalDate.of(2024, 2, 6));
        e1.setDescrizione("Festival della canzone italiana");
        e1.setTipoEvento(TipoEvento.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(28);

        dao.save(e1);

        Evento e2 = dao.getById(1);

        //dao.delete(e2);


    }
}
