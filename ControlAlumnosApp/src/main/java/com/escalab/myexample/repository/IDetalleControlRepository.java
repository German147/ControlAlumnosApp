package com.escalab.myexample.repository;

import com.escalab.myexample.entity.DetalleConsultaApercivimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleControlRepository extends JpaRepository<DetalleConsultaApercivimiento, Integer> {
}
