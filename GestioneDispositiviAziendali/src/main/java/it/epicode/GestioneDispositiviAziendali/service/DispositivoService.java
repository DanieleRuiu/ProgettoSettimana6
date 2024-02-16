package it.epicode.GestioneDispositiviAziendali.service;


import it.epicode.GestioneDispositiviAziendali.model.Dipendente;
import it.epicode.GestioneDispositiviAziendali.model.Dispositivo;
import it.epicode.GestioneDispositiviAziendali.model.DispositivoRequest;
import it.epicode.GestioneDispositiviAziendali.model.StatoDispositivo;
import it.epicode.GestioneDispositiviAziendali.exception.NotFoundException;
import it.epicode.GestioneDispositiviAziendali.model.*;
import it.epicode.GestioneDispositiviAziendali.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteService dipendenteService;



    public Dispositivo getById(long ID) throws NotFoundException {
        return dispositivoRepository.findById(ID).orElseThrow(() -> new NotFoundException("Dispositivo non esiste"));
    }

    public Page<Dispositivo> findAll(Pageable pageable){
        return dispositivoRepository.findAll(pageable);
    }



    public Dispositivo updateDispositivo(Long id, DispositivoRequest dispositivo) throws NotFoundException {
        Dispositivo dispositivoToUpdate = getById(id);
        dispositivoToUpdate.setStato(dispositivo.getStato());
        dispositivoToUpdate.setTipo(dispositivo.getTipo());
        return dispositivoRepository.save(dispositivoToUpdate);
    }

    public Dispositivo save(DispositivoRequest dispositivo) {
        Dispositivo d = new Dispositivo();
        d.setTipo(dispositivo.getTipo());
        d.setStato(dispositivo.getStato());
        return dispositivoRepository.save(d);
    }

    public void deleteById(Long id) {
        dispositivoRepository.deleteById(id);
    }

    public Dispositivo connectDispositivo(Long dipendente_id, Long dispositivo_id) throws NotFoundException {
        Dispositivo dispositivo = getById(dispositivo_id);
        if (dispositivo.getStato() == StatoDispositivo.ASSEGNATO) {
            throw new NotFoundException("Dispositivo non disponibile");
        }
        Dipendente dipendente = dipendenteService.findById(dipendente_id);
        dispositivo.setDipendente(dipendente);
        dispositivo.setStato(StatoDispositivo.ASSEGNATO);
        return dispositivoRepository.save(dispositivo);
    }
}
