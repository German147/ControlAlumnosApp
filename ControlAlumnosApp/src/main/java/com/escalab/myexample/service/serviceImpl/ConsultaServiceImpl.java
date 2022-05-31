package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.dto.Consulta_Lista_Llamado_de_Atencion_DTO;
import com.escalab.myexample.entity.Consulta;
import com.escalab.myexample.exceptions.ConsultaNotFoundException;
import com.escalab.myexample.repository.IConsultaRepositroy;
import com.escalab.myexample.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    IConsultaRepositroy consultaRepositroy;

    @Override
    public Consulta create(Consulta consulta) {
        consulta.getDetalleApercivimiento().forEach(detalle -> {
            detalle.setConsulta(consulta);
        });
        return consultaRepositroy.save(consulta);
    }

    @Override
    public Consulta update(Consulta consulta, Integer id) {
        return consultaRepositroy.save(consulta);
    }

    @Override
    public List<Consulta> findAll() {
        return consultaRepositroy.findAll();
    }

    @Override
    public Consulta findById(Integer id) {
        Optional<Consulta> consulta = consultaRepositroy.findById(id);
        return consulta.orElseGet(Consulta::new);
    }

    @Transactional
    @Override
    public Consulta registrarTransaccional(Consulta_Lista_Llamado_de_Atencion_DTO dto) {
        dto.getConsulta().getDetalleApercivimiento().forEach(detalleAper -> {
            detalleAper.setConsulta(dto.getConsulta());
        });
        consultaRepositroy.save(dto.getConsulta());
        return dto.getConsulta();
    }

    @Override
    public byte[] generarReporte() {
        byte[] data = null;
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer id) {
        Optional<Consulta> consulta = consultaRepositroy.findById(id);
        if (consulta.isPresent()) {
            consultaRepositroy.delete(consulta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ConsultaNotFoundException("La consulta no pudo ser eliminada");
        }
    }
}
