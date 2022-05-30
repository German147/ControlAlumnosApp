package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaRepositroy extends JpaRepository<Consulta,Integer> {



//
//    @Query("from Consulta c where c.alumno.dni =:dni or LOWER(c.alumno.nombre) like %:nombreCompleto% or LOWER(c.alumno.apellido) like %:nombreCompleto%")
//    List<Consulta> buscar(@Param("dni")String dni, @Param("nombreCompleto") String nombreCompleto);
//
//
//    @Query("from Consulta c where c.fecha between :fechaConsulta and :fechaSgte")
//    List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);
//
//   @Query(value = "select * from fn_listarResumen()", nativeQuery = true)
//    List<Object[]> listarResumen();


}
