package com.mx.GS_MiniBlog.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol {

	@Id
	private Long id;

	@Column(nullable = false, length = 50)
	private String tipo;

	public Rol() {
	}

	public Rol(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", tipo=" + tipo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
