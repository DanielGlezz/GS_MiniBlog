package com.mx.GS_MiniBlog.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.GS_MiniBlog.Dao.IPublicacionRepository;
import com.mx.GS_MiniBlog.Models.Publicacion;
import com.mx.GS_MiniBlog.Service.IPublicacionService;

@Service
public class PublicacionServImpl implements IPublicacionService {

    @Autowired
    private IPublicacionRepository publicacionDao;

    @Override
    public void guardar(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    public Publicacion buscar(Publicacion publicacion) {
        return publicacionDao.findById(publicacion.getId()).orElse(null);
    }

    @Override
    public List<Publicacion> listar() {
        return publicacionDao.findAll();
    }

}
