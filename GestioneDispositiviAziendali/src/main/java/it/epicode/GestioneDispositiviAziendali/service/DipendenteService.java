package it.epicode.GestioneDispositiviAziendali.service;

import it.epicode.GestioneDispositiviAziendali.exception.NotFoundException;
import it.epicode.GestioneDispositiviAziendali.model.Dipendente;
import it.epicode.GestioneDispositiviAziendali.model.DipendenteRequest;
import it.epicode.GestioneDispositiviAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;





@Service
public class DipendenteService {

    @Autowired
   private DipendenteRepository dipendenteRepository;




    public Page findAll(Pageable pageable) {
        return dipendenteRepository.findAll(pageable);

    }

    public Dipendente findById(long ID) throws NotFoundException {
        return dipendenteRepository.findById(ID).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));
    }


    public Dipendente updateDipendente(Long id, DipendenteRequest dipendenteRequest)  throws NotFoundException{
       Dipendente d = findById(id);

        d.setNome(dipendenteRequest.getNome());
      d.setCognome(dipendenteRequest.getCognome());
        d.setEmail(dipendenteRequest.getEmail());
        d.setUsername(dipendenteRequest.getUsername());

        return dipendenteRepository.save(d);
    }



    public void deleteById(long id) {
        dipendenteRepository.deleteById(id);
    }





    public Dipendente save(DipendenteRequest dipendenterequest) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendente.getNome());
        dipendente.setCognome(dipendente.getCognome());
        dipendente.setEmail(dipendente.getEmail());
        dipendente.setUsername(dipendente.getUsername());
        return dipendenteRepository.save(dipendente);
    }


}