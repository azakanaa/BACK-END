package epicode.dao;

import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudenteDao {

    private EntityManager em;

    public StudenteDao(EntityManager em) { this.em = em; }

    public void save(Studente Studente){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(Studente);
        //aggiornamento (se ha lo studente) o inserimento (se non ha lo studente)
        et.commit();
    }

    public Studente getById(int matricola){
        Studente s = em.find(Studente.class, matricola);
        //find fa una select
        //dato che estraggo dal database, matricola = chiave primaria
        return s;
    }

    public void delete(Studente studente){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(studente);
        et.commit();
        //non da errore senza entity transaction ma non avrebbe fatto la cancellazione
    }

}
