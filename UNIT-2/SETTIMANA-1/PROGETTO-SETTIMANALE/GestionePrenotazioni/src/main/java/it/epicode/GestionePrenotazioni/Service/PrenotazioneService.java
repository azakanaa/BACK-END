package it.epicode.GestionePrenotazioni.Service;

import it.epicode.GestionePrenotazioni.Bean.Prenotazione;
import it.epicode.GestionePrenotazioni.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneService postazioneService;


    public void inserisciPrenotazione(Prenotazione prenotazione) {
        if (postazioneService.verificaPostazioneLibera(prenotazione.getPostazione(), prenotazione.getData()) &&
                prenotazioneRepository.findByUtenteAndData(prenotazione.getUtente(), prenotazione.getData()).isEmpty()) {
            prenotazioneRepository.save(prenotazione);
            System.out.println("Prenotazione effettuata");
        } else {
            System.out.println("Postazione non disponibile nella data scelta");
        }
    }

    public void eliminaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }
}
