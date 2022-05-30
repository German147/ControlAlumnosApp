package com.escalab.myexample.service;



import com.escalab.myexample.dto.Consulta_Lista_Llamado_de_Atencion_DTO;
import com.escalab.myexample.entity.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {
	
	Consulta registrarTransaccional(Consulta_Lista_Llamado_de_Atencion_DTO dto);


//	List<Consulta> buscarFecha(FiltroConsultaAlumnoDTO filtro);

	byte[] generarReporte();
	

}
