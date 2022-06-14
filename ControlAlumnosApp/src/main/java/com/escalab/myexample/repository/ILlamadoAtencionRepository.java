package com.escalab.myexample.repository;

import com.escalab.myexample.entity.LlamadosDeAtencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILlamadoAtencionRepository extends JpaRepository<LlamadosDeAtencion, Integer> {
}
