package com.mx.GS_MiniBlog.Service;

import java.util.List;

import com.mx.GS_MiniBlog.Models.Rol;

public interface IRolService {

    public void guardar(Rol rol);

    public void editar(Rol rol);

    public void eliminar(Rol rol);

    public Rol buscar(Rol rol);

    public List<Rol> listar();
}
