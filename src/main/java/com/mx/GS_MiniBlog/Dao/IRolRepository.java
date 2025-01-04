package com.mx.GS_MiniBlog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.GS_MiniBlog.Models.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

}
