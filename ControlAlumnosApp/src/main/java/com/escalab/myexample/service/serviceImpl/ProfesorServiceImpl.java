package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Profesor;
import com.escalab.myexample.exceptions.ProfesorNotFoundException;
import com.escalab.myexample.repository.IProfesorRepository;
import com.escalab.myexample.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    IProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(Integer id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            return profesor.get();
        } else {
            throw new ProfesorNotFoundException("El Profesor no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = profesorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El profesor con el id " + id + " no existe en nuestra base de datos");
        }
        profesorRepository.deleteById(id);
    }

    @Override
    public List<Profesor> findAllByName(String name) {
        return profesorRepository.findAllByNombre(name);
    }

    @Override
    public Page<Profesor> listPageable(Pageable pageable) {
        return profesorRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<Object> deleteProfesor(Integer id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            profesorRepository.delete(profesor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ProfesorNotFoundException("El Profesor no fue encontrado");
        }
    }

    @Override
    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Profesor profesor, Integer id) {
        Profesor updatedProfesor = new Profesor();
        if (id != null && id > 0) {
            Optional<Profesor> pro = profesorRepository.findById(id);
            if (pro.isPresent()) {
                profesor.setId(id);
                updatedProfesor = profesorRepository.save(profesor);
            } else {
                throw new ProfesorNotFoundException("El Numero de Id No Existe");
            }
        }
        return updatedProfesor;
    }
}
