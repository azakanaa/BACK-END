package it.epicode.GestionePrenotazioni.service;

import com.cloudinary.Cloudinary;
import it.epicode.GestionePrenotazioni.DTO.DipendenteDto;
import it.epicode.GestionePrenotazioni.exception.DipendenteNonTrovatoException;
import it.epicode.GestionePrenotazioni.model.Dipendente;
import it.epicode.GestionePrenotazioni.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender; // una aggiunta in più

    public Optional<Dipendente> getDipendenteeById(int id) {
        return dipendenteRepository.findById(id);
    }

    // ho messo la funzione di paginamento anche per un ordinamento migliore
    public Page<Dipendente> getAllDipendenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setUsername(dipendenteDto.getUsername());
        // Piccolo dettaglio che la foto profilo è già impostata perché mi era piacuta questa idea dagli esercizi fatti in settimana
        dipendente.setFotoProfilo("https://ui-avatars.com/api/?name=" + dipendente.getNome() + "+" + dipendente.getCognome());
        dipendenteRepository.save(dipendente);
        sendMail(dipendente.getEmail()); // altro dettaglio in più, in modo da poter mandare le email di conferma
        return "Dipendente con id: " + dipendente.getId() + " aggiunto/a con successo";
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {
        Optional<Dipendente> dipendenteOptional = getDipendenteeById(id);

        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setFotoProfilo("https://ui-avatars.com/api/?name=" + dipendente.getNome() + "+" + dipendente.getCognome());

            return dipendenteRepository.save(dipendente);

        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id:" + id + " non trovato/a");
        }
    }

    public String deleteDipendente(int id) {
        Optional<Dipendente> dipendenteOptional = getDipendenteeById(id);

        if (dipendenteOptional.isPresent()) {
            dipendenteRepository.delete(dipendenteOptional.get());
            return "Autore con ID: " + id + " cancellato/a con successo";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id:" + id + " non trovato/a");
        }
    }

    public String patchFoto(int id, MultipartFile foto) throws IOException {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(id);

        if (dipendenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();

            dipendente.setFotoProfilo(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente con ID: " + id + " aggiornato correttamente";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id:" + id + " non trovato/a");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione nuovo dipendente nella piattaforma");
        message.setText("Registrazione avvenuta con successo");

        javaMailSender.send(message);
    }

}