package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {

    List<Profesor> findAllByNombre(String name);
}
