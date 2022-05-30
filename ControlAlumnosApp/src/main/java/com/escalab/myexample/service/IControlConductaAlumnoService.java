package com.escalab.myexample.service;

import com.escalab.myexample.dto.Consulta_DTO;
import com.escalab.myexample.dto.FiltroConsultaAlumnoDTO;
import com.escalab.myexample.entity.Consulta;

import java.util.List;

public interface IControlConductaAlumnoService extends ICRUD<Consulta>{


    Consulta registrarTransactional(Consulta_DTO dto);

    List<Consulta> buscar(FiltroConsultaAlumnoDTO filtro);

    List<Consulta> buscarFecha(FiltroConsultaAlumnoDTO filtro);

    List<Consulta> listarResumen();

}
