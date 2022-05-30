package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArchivoRepository extends JpaRepository<Archivo, Integer> {
}
