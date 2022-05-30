package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Alumno;
import com.escalab.myexample.exceptions.AlumnoNotFoundException;
import com.escalab.myexample.repository.IAlumnoRepository;
import com.escalab.myexample.service.IAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnosService {

    private final IAlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImpl(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Alumno create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno, Integer id) {

        Alumno updatedStudent = new Alumno();
        if (id != null && id > 0) {
            Optional<Alumno> po = alumnoRepository.findById(id);
            if (po.isPresent()) {
             alumno.setId(id);
                updatedStudent = alumnoRepository.save(alumno);
            } else {
                throw new AlumnoNotFoundException("El Numero de Id No Existe");
            }
        }
        return updatedStudent;

    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Integer id) {
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if (alumno.isPresent()) {
            return alumno.get();
        } else {
            throw new AlumnoNotFoundException("El Alumno no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = alumnoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El alumno con el id " + id + " no existe en nuestra base de datos");
        }
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<Alumno> findAllByName(String name) {
        return alumnoRepository.findAllByNombre(name);
    }

    @Override
    public Page<Alumno> listPageable(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<Object> deleteAlumno(Integer id) {
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if (alumno.isPresent()) {
            alumnoRepository.delete(alumno.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new AlumnoNotFoundException("El Alumno no fue encontrado");
        }
    }
}
