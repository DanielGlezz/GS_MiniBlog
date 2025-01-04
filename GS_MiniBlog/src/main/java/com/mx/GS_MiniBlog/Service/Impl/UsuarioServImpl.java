package com.mx.GS_MiniBlog.Service.Impl;

import org.springframework.stereotype.Service;
import com.mx.GS_MiniBlog.Dao.IUsuarioRepository;
import com.mx.GS_MiniBlog.Service.IUsuarioService;
import com.mx.GS_MiniBlog.Models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UsuarioServImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioDao;

    @Override
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        return usuarioDao.findById(usuario.getId()).orElse(null);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioDao.findAll();
    }

}
