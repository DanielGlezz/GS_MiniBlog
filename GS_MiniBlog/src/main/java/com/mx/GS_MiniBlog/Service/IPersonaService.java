package com.mx.GS_MiniBlog.Service;

import java.util.List;

import com.mx.GS_MiniBlog.Models.Persona;

public interface IPersonaService {
    public void guardar(Persona persona);
	
	public void editar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona buscar(Persona persona);
	
	public List<Persona> listar();
}
