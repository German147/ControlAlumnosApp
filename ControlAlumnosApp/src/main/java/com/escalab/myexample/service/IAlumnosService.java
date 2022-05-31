package com.escalab.myexample.service;

import com.escalab.myexample.entity.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAlumnosService extends ICRUD<Alumno>{

    List<Alumno> findAllByName(String name);

    Page<Alumno> listPageable(Pageable pageable);

}
