package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Consulta_Llamado_De_Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaLLamadoAtencionRepository extends JpaRepository<Consulta_Llamado_De_Atencion, Integer> {

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO consultaLlamadoDeAtencion(id_consulta, id_llamadoAtencion) VALUES (:idConsulta, :id_llamadoAtencion)", nativeQuery = true)
//    Integer registrar(@Param("id_consulta") Integer idConsulta, @Param("id_llamadoAtencion") Integer llamadoDeAtencion_id);
//
//    @Query("from consultaLlamadoDeAtencion ce where ce.consulta.id_consulta = :id_consulta")
//    List<Consulta_Llamado_De_Atencion> listarExamenesPorConsulta(@Param("id_consulta") Integer idconsulta);
}
