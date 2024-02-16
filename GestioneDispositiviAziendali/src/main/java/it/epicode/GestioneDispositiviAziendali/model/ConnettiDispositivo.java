package it.epicode.GestioneDispositiviAziendali.model;

public class ConnettiDispositivo {

    private Long idDipendente;
    private Long idDispositivo;

    public ConnettiDispositivo() {
    }

    public ConnettiDispositivo(Long idDipendente, Long idDispositivo) {
        this.idDipendente = idDipendente;
        this.idDispositivo = idDispositivo;
    }
}
