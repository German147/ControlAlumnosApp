package com.escalab.myexample.service;


import com.escalab.myexample.entity.Usuario;

public interface ILoginService {
	
	Usuario verifyUserName(String usuario) throws Exception;
	int changingKey(String clave, String nombre) throws Exception;
}
