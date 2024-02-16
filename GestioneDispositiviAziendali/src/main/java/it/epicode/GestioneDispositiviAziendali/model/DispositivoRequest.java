package it.epicode.GestioneDispositiviAziendali.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoRequest {

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Il tipo non può essere vuoto")
    @NotEmpty(message = "Il tipo è obbligatorio")
    private TipoDispositivo tipo;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Lo stato non può essere vuoto")
    @NotEmpty(message = "Lo stato è obbligatorio")
    private StatoDispositivo stato;


    @NotNull(message = "Il dipendente non può essere vuoto")
    @NotEmpty(message = "Il dipendente è obbligatorio")
    private Dipendente dipendente;

    public DispositivoRequest() {
    }
    public DispositivoRequest(TipoDispositivo tipo, StatoDispositivo status, Dipendente dipendente) {
        this.tipo = tipo;
        this.stato = stato;
        this.dipendente = dipendente;
    }

    public TipoDispositivo getTipo() {
        return tipo;
    }

    public StatoDispositivo getStatus() {
        return stato;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }


    public Long getNome() {
        return null;
    }
}