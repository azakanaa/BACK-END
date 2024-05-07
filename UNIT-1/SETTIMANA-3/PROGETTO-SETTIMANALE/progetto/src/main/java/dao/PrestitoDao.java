package dao;

import entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id) {
        Prestito p = em.find(Prestito.class,id);
        return p;
    }

    public void delete (Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(prestito);
        et.commit();
    }

    public List getByNumeroTesseraUtente(int numeroTessera) {
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> getPrestitiScaduti() {
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva < :oggi OR p.dataRestituzionePrevista IS NULL");
        query.setParameter("oggi", LocalDate.now());
        return query.getResultList();
    }
}
