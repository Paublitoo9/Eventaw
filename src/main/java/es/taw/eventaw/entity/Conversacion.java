package es.taw.eventaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Conversacion {
    private Integer id;
    private Integer teleoperador;
    private Integer usuario;
    private Usuario usuarioByTeleoperador;
    private Usuario usuarioByUsuario;
    private Collection<Mensaje> mensajesById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TELEOPERADOR", nullable = false)
    public Integer getTeleoperador() {
        return teleoperador;
    }

    public void setTeleoperador(Integer teleoperador) {
        this.teleoperador = teleoperador;
    }

    @Basic
    @Column(name = "USUARIO", nullable = false, insertable = false, updatable = false)
    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversacion that = (Conversacion) o;
        return Objects.equals(id, that.id) && Objects.equals(teleoperador, that.teleoperador) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teleoperador, usuario);
    }

    @ManyToOne
    @JoinColumn(name = "TELEOPERADOR", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByTeleoperador() {
        return usuarioByTeleoperador;
    }

    public void setUsuarioByTeleoperador(Usuario usuarioByTeleoperador) {
        this.usuarioByTeleoperador = usuarioByTeleoperador;
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", nullable = false)
    public Usuario getUsuarioByUsuario() {
        return usuarioByUsuario;
    }

    public void setUsuarioByUsuario(Usuario usuarioByUsuario) {
        this.usuarioByUsuario = usuarioByUsuario;
    }

    @OneToMany(mappedBy = "conversacionByConversacion")
    public Collection<Mensaje> getMensajesById() {
        return mensajesById;
    }

    public void setMensajesById(Collection<Mensaje> mensajesById) {
        this.mensajesById = mensajesById;
    }
}
