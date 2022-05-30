package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IApoderadoRepository extends JpaRepository<Apoderado, Integer> {

    List<Apoderado> findAllByNombre(String name);
}
