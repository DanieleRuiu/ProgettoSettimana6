package it.epicode.GestioneDispositiviAziendali.repository;
import it.epicode.GestioneDispositiviAziendali.model.Dipendente;
import it.epicode.GestioneDispositiviAziendali.model.Dispositivo;
import it.epicode.GestioneDispositiviAziendali.model.DispositivoRequest;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.Optional;


public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo, Long> {



}


