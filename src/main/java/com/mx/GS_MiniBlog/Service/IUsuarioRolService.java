package com.mx.GS_MiniBlog.Service;

import java.util.List;

import com.mx.GS_MiniBlog.Models.UsuarioRol;

public interface IUsuarioRolService {
    public void guardar(UsuarioRol usuarioRol);

    public void editar(UsuarioRol usuarioRol);

    public void eliminar(UsuarioRol usuarioRol);

    public UsuarioRol buscar(UsuarioRol usuarioRol);

    public List<UsuarioRol> listar();
}
