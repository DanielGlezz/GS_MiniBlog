package com.mx.GS_MiniBlog.Service;

import java.util.List;

import com.mx.GS_MiniBlog.Models.Publicacion;

public interface IPublicacionService {
    public void guardar(Publicacion publicacion);

    public Publicacion buscar(Publicacion publicacion);

    public List<Publicacion> listar();
}
