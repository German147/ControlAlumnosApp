package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Archivo;
import com.escalab.myexample.repository.IArchivoRepository;
import com.escalab.myexample.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
	IArchivoRepository archivoRepository;

    @Override
    public int guardar(Archivo archivo) {
        Archivo ar = archivoRepository.save(archivo);
        return ar.getIdArchivo() > 0 ? 1 : 0;
    }

    @Override
    public byte[] leerArchivo(Integer idArchivo) {
        Optional<Archivo> op = archivoRepository.findById(idArchivo);
        return op.isPresent() ? op.get().getValue() : new byte[0];
    }
}
