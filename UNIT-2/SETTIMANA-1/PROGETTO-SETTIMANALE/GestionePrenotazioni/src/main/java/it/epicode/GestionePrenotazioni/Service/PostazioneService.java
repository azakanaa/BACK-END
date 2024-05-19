package it.epicode.GestionePrenotazioni.Service;

import it.epicode.GestionePrenotazioni.Bean.Postazione;
import it.epicode.GestionePrenotazioni.Bean.Prenotazione;
import it.epicode.GestionePrenotazioni.Enums.Tipo;
import it.epicode.GestionePrenotazioni.Repository.PostazioneRepository;
import it.epicode.GestionePrenotazioni.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public boolean verificaPostazioneLibera(Postazione postazione, LocalDate date) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndData(postazione, date);
        return prenotazioni.isEmpty();
    }


    public void inserisciPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public Postazione getPostazioneById(int id) {
        return postazioneRepository.findById(id).get();
    }

    public void eliminaPrenotazione (int id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> ricercaPostazioniPerTipoECitta(Tipo tipo, String citta){
        return postazioneRepository.cercaPostazioniPerTipoECitta(tipo, citta);
    }
}
