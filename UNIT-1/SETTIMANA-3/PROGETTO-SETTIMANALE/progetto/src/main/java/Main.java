import dao.ElementoDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entity.Libri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto");
        EntityManager em = emf.createEntityManager();

        ElementoDao elementoDao = new ElementoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);

        Libri libri = new Libri();
        libri.setAutore("André Aciman");
        libri.setGenere("Romanzo");
        libri.setAnnoPubblicazione(2019);
        libri.setTitolo("Chiamami col tuo nome");
        libri.setNumeroPagine(272);

        elementoDao.save(libri);

//        Riviste riviste = new Riviste();
//        riviste.setPeriodicita(Riviste.Periodicita.MENSILE);
//        riviste.setAnnoPubblicazione(2024);
//        riviste.setTitolo("Vogue");
//        riviste.setNumeroPagine(45);

//        elementoDao.save(riviste);



        System.out.println("ricerca tramite ISBN");
        System.out.println(elementoDao.getISBNElemento(UUID.fromString("978-8823524163")));

        System.out.println("ricerca per anno pubblicazione");
        System.out.println(elementoDao.getAnnoElemento(2019));

        System.out.println("ricerca per autore");
        System.out.println(elementoDao.getAutoreElemento("André Aciman"));

        System.out.println("ricerca per titolo");
        System.out.println(elementoDao.getTitoloElemento("Chiamami col tuo nome"));

//        Utente utente = new Utente();
//        utente.setDataDiNascita(LocalDate.of(2024, 12, 30));
//        utente.setNome("Elena");
//        utente.setCognome("Kekic");
//        utenteDao.save(utente);

//        Prestito prestito = new Prestito();
//        prestito.setUtente(utente);
//        prestito.setElementoPrestato(libri);
//        prestito.setDataInizioPrestito(LocalDate.of(2024, 01, 04));
//        prestito.setDataRestituzioneEffettiva(LocalDate.of(2024, 05, 04));
//        prestitoDao.save(prestito);

        System.out.println("ricerca elementi prestati tramite numero tessera");
        prestitoDao.getByNumeroTesseraUtente(4).forEach(System.out::println);

        System.out.println("ricerca prestiti scaduti");
        prestitoDao.getPrestitiScaduti().forEach(System.out::println);
    }
}

