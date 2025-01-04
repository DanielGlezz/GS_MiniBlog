package com.mx.GS_MiniBlog.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioRol")
public class UsuarioRol {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public UsuarioRol(Long id, Rol rol, Usuario usuario) {
        super();
        this.id = id;
        this.rol = rol;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "UsuarioRol [id=" + id + ", rol=" + rol + ", usuario=" + usuario + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
