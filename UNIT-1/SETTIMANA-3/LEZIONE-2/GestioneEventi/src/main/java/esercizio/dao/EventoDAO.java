package esercizio.dao;

import esercizio.entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {this.em = em;}

    public void save(Evento Evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(Evento);
        et.commit();
    }

    public Evento getById(int id){
        Evento e = em.find(Evento.class, id);
        return e;
    }

    public void delete(Evento evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }
}
