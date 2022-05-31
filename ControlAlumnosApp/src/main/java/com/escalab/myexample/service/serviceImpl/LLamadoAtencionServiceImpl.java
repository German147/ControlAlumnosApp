package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Alumno;
import com.escalab.myexample.entity.Llamados_de_Atencion;
import com.escalab.myexample.exceptions.AlumnoNotFoundException;
import com.escalab.myexample.exceptions.LlamadosAtencionNotFoundException;
import com.escalab.myexample.repository.ILlamadoAtencionRepository;
import com.escalab.myexample.service.ILlamadoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LLamadoAtencionServiceImpl implements ILlamadoAtencionService {

    @Autowired
    ILlamadoAtencionRepository llamadoAtencionRepository;

    @Override
    public Llamados_de_Atencion create(Llamados_de_Atencion llamadosDeAtencion) {
        return llamadoAtencionRepository.save(llamadosDeAtencion);
    }

    @Override
    public Llamados_de_Atencion update(Llamados_de_Atencion llamadosDeAtencion, Integer id) {
        Llamados_de_Atencion updateLlamadoAt = new Llamados_de_Atencion();
        if (id != null && id > 0) {
            Optional<Llamados_de_Atencion> po = llamadoAtencionRepository.findById(id);
            if (po.isPresent()) {
                llamadosDeAtencion.setLlamadoDeAtencion_id(id);
                updateLlamadoAt = llamadoAtencionRepository.save(llamadosDeAtencion);
            } else {
                throw new LlamadosAtencionNotFoundException("El llamado de atencion con el numero de Id: "
                        + llamadosDeAtencion.getLlamadoDeAtencion_id() + " no existe");
            }
        }
        return updateLlamadoAt;
    }

    @Override
    public List<Llamados_de_Atencion> findAll() {
        return llamadoAtencionRepository.findAll();
    }

    @Override
    public Llamados_de_Atencion findById(Integer id) {
        Optional<Llamados_de_Atencion> llamadAt = llamadoAtencionRepository.findById(id);
        if (llamadAt.isPresent()) {
            return llamadAt.get();
        } else {
            throw new LlamadosAtencionNotFoundException("El llamado de atencion con el numero de Id: no existe");
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer id) {
        Optional<Llamados_de_Atencion> llamadoAt = llamadoAtencionRepository.findById(id);
        if (llamadoAt.isPresent()) {
            llamadoAtencionRepository.delete(llamadoAt.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new AlumnoNotFoundException("El Alumno no fue encontrado");
        }
    }

    @Override
    public Page<Llamados_de_Atencion> listLlamadoAtencionPageable(Pageable pageable) {
        return llamadoAtencionRepository.findAll(pageable);
    }

}
