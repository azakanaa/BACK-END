package dao;

import entity.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class ElementoDao {
    private EntityManager em;

    public ElementoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Elemento elemento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(elemento);
        et.commit();
    }


    public Elemento getByISBN(UUID ISBN) {
        return em.find(Elemento.class, ISBN);
    }

    public void delete(UUID ISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Elemento elemento = getByISBN(ISBN);

        if (elemento != null) {
            em.remove(elemento);
        } else {
            System.out.println("Elemento non disponibile");
        }

        et.commit();
    }

    public Elemento getISBNElemento(UUID ISBN) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.ISBN = :ISBN");
        query.setParameter("ISBN", ISBN);
        return (Elemento)query.getSingleResult();
    }

    public List getAnnoElemento(int annoPubblicazione) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno");
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

    public List getAutoreElemento(String autore) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.autore = :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List getTitoloElemento(String titolo) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }



}