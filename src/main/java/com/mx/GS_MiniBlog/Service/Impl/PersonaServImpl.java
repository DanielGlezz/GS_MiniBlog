package com.mx.GS_MiniBlog.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.GS_MiniBlog.Dao.IPersonaRepository;
import com.mx.GS_MiniBlog.Models.Persona;
import com.mx.GS_MiniBlog.Service.IPersonaService;

@Service
public class PersonaServImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository personaDao;

    @Override
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void editar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    public Persona buscar(Persona persona) {
        return personaDao.findById(persona.getId()).orElse(null);
    }

    @Override
    public List<Persona> listar() {
        return personaDao.findAll();
    }

}
