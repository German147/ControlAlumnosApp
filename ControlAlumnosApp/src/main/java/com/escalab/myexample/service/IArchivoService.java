package com.escalab.myexample.service;

import com.escalab.myexample.entity.Archivo;

public interface IArchivoService {

    int guardar(Archivo archivo);

    byte[] leerArchivo(Integer idArchivo);
}
