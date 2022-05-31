package com.escalab.myexample.service;

import com.escalab.myexample.entity.Apoderado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IApoderadoService extends ICRUD<Apoderado>{

    List<Apoderado> findAllByName(String name);

    Page<Apoderado> listPageable(Pageable pageable);

}
