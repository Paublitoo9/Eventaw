package es.taw.eventaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Entrada {
    private Integer id;
    private Integer usuario;
    private Integer evento;
    private Integer numfila;
    private Integer asientofila;
    private Usuarioevento usuarioeventoByUsuario;
    private Evento eventoByEvento;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USUARIO", nullable = false, insertable = false, updatable = false)
    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "EVENTO", nullable = false, insertable = false, updatable = false)
    public Integer getEvento() {
        return evento;
    }

    public void setEvento(Integer evento) {
        this.evento = evento;
    }

    @Basic
    @Column(name = "NUMFILA", nullable = true)
    public Integer getNumfila() {
        return numfila;
    }

    public void setNumfila(Integer numfila) {
        this.numfila = numfila;
    }

    @Basic
    @Column(name = "ASIENTOFILA", nullable = true)
    public Integer getAsientofila() {
        return asientofila;
    }

    public void setAsientofila(Integer asientofila) {
        this.asientofila = asientofila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(id, entrada.id) && Objects.equals(usuario, entrada.usuario) && Objects.equals(evento, entrada.evento) && Objects.equals(numfila, entrada.numfila) && Objects.equals(asientofila, entrada.asientofila);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, evento, numfila, asientofila);
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", nullable = false)
    public Usuarioevento getUsuarioeventoByUsuario() {
        return usuarioeventoByUsuario;
    }

    public void setUsuarioeventoByUsuario(Usuarioevento usuarioeventoByUsuario) {
        this.usuarioeventoByUsuario = usuarioeventoByUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "EVENTO", referencedColumnName = "ID", nullable = false)
    public Evento getEventoByEvento() {
        return eventoByEvento;
    }

    public void setEventoByEvento(Evento eventoByEvento) {
        this.eventoByEvento = eventoByEvento;
    }
}
