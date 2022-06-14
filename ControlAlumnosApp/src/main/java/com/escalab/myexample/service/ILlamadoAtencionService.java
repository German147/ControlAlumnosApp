package com.escalab.myexample.service;

import com.escalab.myexample.entity.LlamadosDeAtencion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILlamadoAtencionService extends ICRUD<LlamadosDeAtencion>{

    Page<LlamadosDeAtencion> listLlamadoAtencionPageable(Pageable pageable);

}
