package com.mx.GS_MiniBlog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.GS_MiniBlog.Models.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Long> {

}
