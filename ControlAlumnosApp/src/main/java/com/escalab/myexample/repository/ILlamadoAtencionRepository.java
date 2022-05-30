package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Llamados_de_Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILlamadoAtencionRepository extends JpaRepository<Llamados_de_Atencion, Integer> {
}
