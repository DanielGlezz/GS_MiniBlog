package com.mx.GS_MiniBlog.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.GS_MiniBlog.Dao.IRolRepository;
import com.mx.GS_MiniBlog.Models.Rol;
import com.mx.GS_MiniBlog.Service.IRolService;

@Service
public class RolServImpl implements IRolService {

    @Autowired
    private IRolRepository rolDao;

    @Override
    public void guardar(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void editar(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void eliminar(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    public Rol buscar(Rol rol) {
        return rolDao.findById(rol.getId()).orElse(null);
    }

    @Override
    public List<Rol> listar() {
        return rolDao.findAll();
    }

}
