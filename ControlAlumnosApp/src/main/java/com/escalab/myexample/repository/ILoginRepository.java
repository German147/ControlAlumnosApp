package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ILoginRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("FROM Usuario us where us.nombre = :usuario")
	Usuario verifyUserName(@Param("usuario") String usuario) throws Exception;
	
	//Usuario findOneByUsername(String usuario)
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario us SET us.clave = :clave WHERE us.nombre = :nombre")
	void changingKey(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;

}
