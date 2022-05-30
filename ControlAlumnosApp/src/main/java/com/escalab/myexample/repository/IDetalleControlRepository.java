package com.escalab.myexample.repository;

import com.escalab.myexample.entity.DetalleConsulta_Apercivimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleControlRepository extends JpaRepository<DetalleConsulta_Apercivimiento, Integer> {
}
