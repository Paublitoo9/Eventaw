package es.taw.eventaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Mensaje {
    private Integer id;
    private String contenido;
    private Date fecha;
    private Integer emisor;
    private Integer conversacion;
    private Usuario usuarioByEmisor;
    private Conversacion conversacionByConversacion;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CONTENIDO", nullable = false, length = 500)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "EMISOR", nullable = false, insertable = false, updatable = false)
    public Integer getEmisor() {
        return emisor;
    }

    public void setEmisor(Integer emisor) {
        this.emisor = emisor;
    }

    @Basic
    @Column(name = "CONVERSACION", nullable = false, insertable = false, updatable = false)
    public Integer getConversacion() {
        return conversacion;
    }

    public void setConversacion(Integer conversacion) {
        this.conversacion = conversacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensaje mensaje = (Mensaje) o;
        return Objects.equals(id, mensaje.id) && Objects.equals(contenido, mensaje.contenido) && Objects.equals(fecha, mensaje.fecha) && Objects.equals(emisor, mensaje.emisor) && Objects.equals(conversacion, mensaje.conversacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contenido, fecha, emisor, conversacion);
    }

    @ManyToOne
    @JoinColumn(name = "EMISOR", referencedColumnName = "ID", nullable = false)
    public Usuario getUsuarioByEmisor() {
        return usuarioByEmisor;
    }

    public void setUsuarioByEmisor(Usuario usuarioByEmisor) {
        this.usuarioByEmisor = usuarioByEmisor;
    }

    @ManyToOne
    @JoinColumn(name = "CONVERSACION", referencedColumnName = "ID", nullable = false)
    public Conversacion getConversacionByConversacion() {
        return conversacionByConversacion;
    }

    public void setConversacionByConversacion(Conversacion conversacionByConversacion) {
        this.conversacionByConversacion = conversacionByConversacion;
    }
}
