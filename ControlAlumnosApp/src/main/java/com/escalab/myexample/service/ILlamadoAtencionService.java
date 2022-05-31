package com.escalab.myexample.service;

import com.escalab.myexample.entity.Alumno;
import com.escalab.myexample.entity.Llamados_de_Atencion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILlamadoAtencionService extends ICRUD<Llamados_de_Atencion>{

    Page<Llamados_de_Atencion> listLlamadoAtencionPageable(Pageable pageable);

}
