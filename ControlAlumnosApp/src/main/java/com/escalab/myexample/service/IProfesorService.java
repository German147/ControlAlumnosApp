package com.escalab.myexample.service;

import com.escalab.myexample.entity.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProfesorService extends ICRUD<Profesor> {

    List<Profesor> findAllByName(String name);

    Page<Profesor> listPageable(Pageable pageable);

}
