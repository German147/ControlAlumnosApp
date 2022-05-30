package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findAllByNombre(String name);
}
