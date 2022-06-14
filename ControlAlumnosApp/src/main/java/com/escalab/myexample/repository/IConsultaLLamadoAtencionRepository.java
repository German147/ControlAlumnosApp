package com.escalab.myexample.repository;

import com.escalab.myexample.entity.ConsultaLlamadoDeAtencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaLLamadoAtencionRepository extends JpaRepository<ConsultaLlamadoDeAtencion, Integer> {

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO consultaLlamadoDeAtencion(id_consulta, id_llamadoAtencion) VALUES (:idConsulta, :id_llamadoAtencion)", nativeQuery = true)
//    Integer registrar(@Param("id_consulta") Integer idConsulta, @Param("id_llamadoAtencion") Integer llamadoDeAtencion_id);
//
//    @Query("from consultaLlamadoDeAtencion ce where ce.consulta.id_consulta = :id_consulta")
//    List<ConsultaLlamadoDeAtencion> listarExamenesPorConsulta(@Param("id_consulta") Integer idconsulta);
}
