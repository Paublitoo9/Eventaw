package es.taw.eventaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rol {
    private Integer id;
    private String tipo;
    private Collection<Usuario> usuariosById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TIPO", nullable = false, length = 15)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id) && Objects.equals(tipo, rol.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }

    @OneToMany(mappedBy = "rolByRol")
    public Collection<Usuario> getUsuariosById() {
        return usuariosById;
    }

    public void setUsuariosById(Collection<Usuario> usuariosById) {
        this.usuariosById = usuariosById;
    }
}
