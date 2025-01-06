package com.mx.GS_MiniBlog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.GS_MiniBlog.Models.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
