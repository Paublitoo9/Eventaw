package es.taw.eventaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EVENTO_ETIQUETA", schema = "EVENTAWBD", catalog = "")
public class EventoEtiqueta {
    private Integer id;
    private Integer evento;
    private Integer etiqueta;
    private Evento eventoByEvento;
    private Etiqueta etiquetaByEtiqueta;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "ETIQUETA", nullable = false, insertable = false, updatable = false)
    public Integer getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Integer etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventoEtiqueta that = (EventoEtiqueta) o;
        return Objects.equals(id, that.id) && Objects.equals(evento, that.evento) && Objects.equals(etiqueta, that.etiqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, evento, etiqueta);
    }

    @ManyToOne
    @JoinColumn(name = "EVENTO", referencedColumnName = "ID", nullable = false)
    public Evento getEventoByEvento() {
        return eventoByEvento;
    }

    public void setEventoByEvento(Evento eventoByEvento) {
        this.eventoByEvento = eventoByEvento;
    }

    @ManyToOne
    @JoinColumn(name = "ETIQUETA", referencedColumnName = "ID", nullable = false)
    public Etiqueta getEtiquetaByEtiqueta() {
        return etiquetaByEtiqueta;
    }

    public void setEtiquetaByEtiqueta(Etiqueta etiquetaByEtiqueta) {
        this.etiquetaByEtiqueta = etiquetaByEtiqueta;
    }
}
