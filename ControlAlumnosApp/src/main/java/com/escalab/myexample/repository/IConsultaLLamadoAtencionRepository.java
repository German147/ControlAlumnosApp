package com.escalab.myexample.repository;

import com.escalab.myexample.entity.ConsultaLlamadoDeAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsultaLLamadoAtencionRepository extends JpaRepository<ConsultaLlamadoDeAtencion, Integer> {

   // @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO consulta_llamado_de_atencion(id_consulta, id_llamado_atencion) VALUES (:idConsulta, :id_llamadoAtencion)", nativeQuery = true)
//    Integer registrar(@Param("id_consulta") Integer idConsulta, @Param("id_llamadoAtencion") Integer llamadoDeAtencion_id);
//
//    @Query("from consulta_llamado_de_atencion ce where ce.consulta.id_consulta = :id_consulta")
//    List<ConsultaLlamadoDeAtencion> listarExamenesPorConsulta(@Param("id_consulta") Integer idconsulta);
}
