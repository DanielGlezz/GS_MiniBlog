package com.mx.GS_MiniBlog.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private Persona persona;

    @Column(nullable = false, columnDefinition = "NVARCHAR2(2000)")
    private String cuerpo;

    public Publicacion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

}
