package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.DTO.ComputerDto;
import it.epicode.GestionePrenotazioni.DTO.SmartphoneDto;
import it.epicode.GestionePrenotazioni.enumType.StatoDispositivo;
import it.epicode.GestionePrenotazioni.exception.DipendenteNonTrovatoException;
import it.epicode.GestionePrenotazioni.exception.DispositivoNonTrovatoException;
import it.epicode.GestionePrenotazioni.model.Computer;
import it.epicode.GestionePrenotazioni.model.Dipendente;
import it.epicode.GestionePrenotazioni.model.Dispositivo;
import it.epicode.GestionePrenotazioni.model.Smartphone;
import it.epicode.GestionePrenotazioni.repository.ComputerRepository;
import it.epicode.GestionePrenotazioni.repository.DipendenteRepository;
import it.epicode.GestionePrenotazioni.repository.DispositivoRepository;
import it.epicode.GestionePrenotazioni.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Autowired
    private ComputerRepository computerRepository;

    public Optional<Smartphone> getSmartphoneById(int id) {
        return smartphoneRepository.findById(id);
    }

    public Optional<Computer> getComputerById(int id) {
        return computerRepository.findById(id);
    }

    public Page<Dispositivo> getAllDispositivi(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dispositivoRepository.findAll(pageable);
    }

    public Page<Smartphone> getAllSmartphones(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return smartphoneRepository.findAll(pageable);
    }

    public Page<Computer> getAllComputers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return computerRepository.findAll(pageable);
    }

    public String saveSmartphone(SmartphoneDto smartphoneDto) {

        //se voglio salvare uno smartphone non assegnato ad un dipendente
        if (smartphoneDto.getStato() == StatoDispositivo.IN_MANUTENZIONE ||
                smartphoneDto.getStato() == StatoDispositivo.DISPONIBILE ||
                smartphoneDto.getStato() == StatoDispositivo.DISMESSO) {
            Smartphone smartphone = new Smartphone();

            smartphone.setMemoria(smartphoneDto.getMemoria());
            smartphone.setModello(smartphoneDto.getModello());
            smartphone.setStato(smartphoneDto.getStato());
            dispositivoRepository.save(smartphone);
            smartphoneRepository.save(smartphone);

            if (smartphoneDto.getDipendenteId() != 0) {
                throw new DipendenteNonTrovatoException("Non si può assegnare un dipendente con questo tipo di stato");
            }
            return "Smartphone salvato correttamente.";
        }

        if (smartphoneDto.getStato() == StatoDispositivo.ASSEGNATO) {
            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(smartphoneDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Smartphone smartphone = new Smartphone();
                smartphone.setMemoria(smartphoneDto.getMemoria());
                smartphone.setModello(smartphoneDto.getModello());
                smartphone.setStato(smartphoneDto.getStato());
                smartphone.setDipendente(dipendenteOptional.get());
                dispositivoRepository.save(smartphone);
                smartphoneRepository.save(smartphone);
                return "Computer assegnato al dipendente con ID: " + smartphoneDto.getDipendenteId();
            } else {
                throw new DipendenteNonTrovatoException("Dipendente con ID: " + smartphoneDto.getDipendenteId() + " non trovato!");
            }
        } else {
            return "Stato dispositivo non valido!";
        }
    }

    public String saveComputer(ComputerDto computerDto) {

        if (computerDto.getStato() == StatoDispositivo.IN_MANUTENZIONE ||
                computerDto.getStato() == StatoDispositivo.DISPONIBILE ||
                computerDto.getStato() == StatoDispositivo.DISMESSO) {
            Computer computer = new Computer();
            computer.setMemoria(computerDto.getMemoria());
            computer.setModello(computerDto.getModello());
            computer.setStato(computerDto.getStato());
            dispositivoRepository.save(computer);
            computerRepository.save(computer);

            if (computerDto.getDipendenteId() != 0) {
                throw new DipendenteNonTrovatoException("Non si può assegnare un dipendente con questo tipo di stato");
            }
            return "Computer salvato correttamente.";
        }

        if (computerDto.getStato() == StatoDispositivo.ASSEGNATO) {
            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(computerDto.getDipendenteId());
            if (dipendenteOptional.isPresent()) {
                Computer computer = new Computer();
                computer.setMemoria(computerDto.getMemoria());
                computer.setModello(computerDto.getModello());
                computer.setStato(computerDto.getStato());
                computer.setDipendente(dipendenteOptional.get());
                dispositivoRepository.save(computer);
                computerRepository.save(computer);
                return "Computer assegnato al dipendente con ID: " + computerDto.getDipendenteId();
            } else {
                throw new DipendenteNonTrovatoException("Dipendente con ID: " + computerDto.getDipendenteId() + " non trovato!");
            }
        } else {
            return "Stato dispositivo non valido!";
        }
    }

    public Smartphone updateSmartphone(int id, SmartphoneDto smartphoneDto) {
        Optional<Smartphone> smartphoneOptional = smartphoneRepository.findById(id);
        if (smartphoneOptional.isPresent()) {

            Smartphone smartphone = smartphoneOptional.get();

            if (smartphoneDto.getStato() == StatoDispositivo.ASSEGNATO) {
                Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(smartphoneDto.getDipendenteId());
                if (dipendenteOptional.isPresent()) {
                    smartphone.setMemoria(smartphoneDto.getMemoria());
                    smartphone.setModello(smartphoneDto.getModello());
                    smartphone.setStato(smartphoneDto.getStato());
                    smartphone.setDipendente(dipendenteOptional.get());
                    smartphoneRepository.save(smartphone);
                    return smartphone;
                } else {
                    throw new DipendenteNonTrovatoException("Dipendente con ID: " + smartphoneDto.getDipendenteId() + " non trovato!");
                }
            } else if (smartphone.getStato() == StatoDispositivo.IN_MANUTENZIONE ||
                    smartphone.getStato() == StatoDispositivo.DISPONIBILE ||
                    smartphone.getStato() == StatoDispositivo.DISMESSO) {

                smartphone.setMemoria(smartphoneDto.getMemoria());
                smartphone.setModello(smartphoneDto.getModello());
                smartphone.setStato(smartphoneDto.getStato());
                smartphoneRepository.save(smartphone);
                if (smartphoneDto.getDipendenteId() != 0) {
                    throw new DipendenteNonTrovatoException("Non si può assegnare un dipendente con questo tipo di stato");
                }
                return smartphone;
            } else {
                throw new DispositivoNonTrovatoException("Stato dispositivo non valido!");
            }
        } else {
            throw new DispositivoNonTrovatoException("Smartphone con ID: " + id + " non trovato!");
        }
    }

    public Computer updateComputer(int id, ComputerDto computerDto) {
        Optional<Computer> computerOptional = computerRepository.findById(id);
        if (computerOptional.isPresent()) {

            Computer computer = computerOptional.get();

            if (computerDto.getStato() == StatoDispositivo.ASSEGNATO) {
                Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(computerDto.getDipendenteId());
                if (dipendenteOptional.isPresent()) {
                    computer.setMemoria(computerDto.getMemoria());
                    computer.setModello(computerDto.getModello());
                    computer.setStato(computerDto.getStato());
                    computer.setDipendente(dipendenteOptional.get());
                    computerRepository.save(computer);
                    return computer;
                } else {
                    throw new DipendenteNonTrovatoException("Dipendente con ID: " + computerDto.getDipendenteId() + " non trovato!");
                }
            } else if (computer.getStato() == StatoDispositivo.IN_MANUTENZIONE ||
                    computer.getStato() == StatoDispositivo.DISPONIBILE ||
                    computer.getStato() == StatoDispositivo.DISMESSO) {

                computer.setMemoria(computerDto.getMemoria());
                computer.setModello(computerDto.getModello());
                computer.setStato(computerDto.getStato());
                computerRepository.save(computer);
                if (computerDto.getDipendenteId() != 0) {
                    throw new DipendenteNonTrovatoException("Non si può assegnare un dipendente con questo tipo di stato");
                }
                return computer;
            } else {
                throw new DispositivoNonTrovatoException("Stato dispositivo non valido!");
            }
        } else {
            throw new DispositivoNonTrovatoException("Computer con ID: " + id + " non trovato!");
        }
    }

    public String deleteSmartphone(int id) {
        Optional<Smartphone> smartphoneOptional = getSmartphoneById(id);

        if (smartphoneOptional.isPresent()) {
            dispositivoRepository.delete(smartphoneOptional.get());
            smartphoneRepository.delete(smartphoneOptional.get());
            return "Smartphone con ID: " + id + "cancellato con successo";
        } else {
            throw new DispositivoNonTrovatoException("Smartphone con id:" + id + " non trovato");
        }
    }

    public String deleteComputer(int id) {
        Optional<Computer> computerOptional = getComputerById(id);

        if (computerOptional.isPresent()) {
            dispositivoRepository.delete(computerOptional.get());
            computerRepository.delete(computerOptional.get());
            return "Computer con ID: " + id + "cancellato con successo";
        } else {
            throw new DispositivoNonTrovatoException("Computer con id:" + id + " non trovato");
        }
    }

    public String patchSmartphoneDipendente(int dipendenteId, int smartphoneId) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dipendenteId);
        Optional<Smartphone> smartphoneOptional = smartphoneRepository.findById(smartphoneId);

        if (dipendenteOptional.isPresent() && smartphoneOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            Smartphone smartphone = smartphoneOptional.get();

            if (smartphone.getStato() == StatoDispositivo.DISPONIBILE) {

                smartphone.setStato(StatoDispositivo.ASSEGNATO);
                smartphone.setDipendente(dipendente);


                return "Smartphone " + smartphone.getModello() + " assegnato al dipendente con Id: " + dipendente.getId();
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo non disponibile, aggiornare prima lo stato del dispositivo");
            }
        } else {
            if (dipendenteOptional.isEmpty()) {
                throw new DipendenteNonTrovatoException("Dipendente con id " + dipendenteId + " non trovato");
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo con id " + smartphoneId + " non trovato");
            }
        }
    }

    public String patchComputerDipendente(int dipendenteId, int computerId) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dipendenteId);
        Optional<Computer> computerOptional = computerRepository.findById(computerId);

        if (dipendenteOptional.isPresent() && computerOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            Computer computer = computerOptional.get();

            if (computer.getStato() == StatoDispositivo.DISPONIBILE) {

                computer.setStato(StatoDispositivo.ASSEGNATO);
                computer.setDipendente(dipendente);


                return "Smartphone " + computer.getModello() + " assegnato al dipendente con Id: " + dipendente.getId();
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo non disponibile, aggiornare prima lo stato del dispositivo");
            }
        } else {
            if (dipendenteOptional.isEmpty()) {
                throw new DipendenteNonTrovatoException("Dipendente con id " + dipendenteId + " non trovato");
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo con id " + computerId + " non trovato");
            }
        }
    }


}