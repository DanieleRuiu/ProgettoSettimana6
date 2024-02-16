package it.epicode.GestioneDispositiviAziendali.model;

import jakarta.persistence.*;




@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo() {
    }

    public Dispositivo(Long id, TipoDispositivo tipo, StatoDispositivo stato) {
        this.id = id;
        this.tipo = tipo;
        this.stato = stato;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDispositivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoDispositivo tipo) {
        this.tipo = tipo;
    }

    public StatoDispositivo getStato() {
        return stato;
    }

    public void setStato(StatoDispositivo stato) {
        this.stato = stato;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }


    @Override
public String toString() {
    return "Dispositivo{" +
            "id=" + id +
            ", tipo=" + tipo +
            ", stato=" + stato +
            ", dipendente=" + dipendente +
            '}';

}

    public void setNome(Long nome) {

    }
}
