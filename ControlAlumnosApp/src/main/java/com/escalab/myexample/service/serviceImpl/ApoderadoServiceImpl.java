package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Apoderado;
import com.escalab.myexample.exceptions.ApoderadoNotFoundException;
import com.escalab.myexample.repository.IApoderadoRepository;
import com.escalab.myexample.service.IApoderadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoServiceImpl implements IApoderadoService {

    private final IApoderadoRepository apoderadoRepository;

    @Autowired
    public ApoderadoServiceImpl(IApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }


    @Override
    public Apoderado create(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public Apoderado update(Apoderado apoderado, Integer id) {
        Apoderado updatedStudent = new Apoderado();
        if (id != null && id > 0) {
            Optional<Apoderado> po = apoderadoRepository.findById(id);
            if (po.isPresent()) {
                apoderado.setIdApoderado(id);
                updatedStudent = apoderadoRepository.save(apoderado);
            } else {
                throw new ApoderadoNotFoundException("El numero de Id " + apoderado.getIdApoderado() + " No Existe");
            }
        }
        return updatedStudent;
    }

    @Override
    public List<Apoderado> findAll() {
        return apoderadoRepository.findAll();
    }

    @Override
    public Apoderado findById(Integer id) {
        Optional<Apoderado> apoderado = apoderadoRepository.findById(id);
        if (apoderado.isPresent()) {
            return apoderado.get();
        } else {
            throw new ApoderadoNotFoundException("El Apoderado no fue encontrado");
        }
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = apoderadoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El apoderado con el id " + id + " no existe en nuestra base de datos");
        }
        apoderadoRepository.deleteById(id);
    }

    @Override
    public List<Apoderado> findAllByName(String name) {
        return apoderadoRepository.findAllByNombre(name);
    }

    @Override
    public Page<Apoderado> listPageable(Pageable pageable) {
        return apoderadoRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<Object> deleteApoderado(Integer id) {
        Optional<Apoderado> apoderado = apoderadoRepository.findById(id);
        if (apoderado.isPresent()) {
            apoderadoRepository.delete(apoderado.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ApoderadoNotFoundException("El Apoderado no fue encontrado");
        }
    }
}
