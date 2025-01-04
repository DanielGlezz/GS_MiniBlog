package com.mx.GS_MiniBlog.Service;

import java.util.List;

import com.mx.GS_MiniBlog.Models.Usuario;

public interface IUsuarioService {
    public void guardar(Usuario usuario);

    public void editar(Usuario usuario);

    public void eliminar(Usuario usuario);

    public Usuario buscar(Usuario usuario);

    public List<Usuario> listar();
}
