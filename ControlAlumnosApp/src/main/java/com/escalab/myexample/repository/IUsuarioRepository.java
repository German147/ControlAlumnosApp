package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findOneByNombre(String username);
}
