package dao;

import entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {

    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getById(int numeroTessera) {
        Utente u = em.find(Utente.class, numeroTessera);
        return u;
    }

    public void delete (Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(utente);
        et.commit();
    }
}