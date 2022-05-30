package com.escalab.myexample.dto;


import com.escalab.myexample.entity.Alumno;
import com.escalab.myexample.entity.Apoderado;
import com.escalab.myexample.entity.Profesor;
import org.springframework.hateoas.ResourceSupport;

public class Consulta_DTO extends ResourceSupport {

    private Integer idColsulta_llamado_atencion;
    private Alumno alumno;
    private Apoderado apoderado;
    private Profesor profesor;

    public Integer getIdColsulta_llamado_atencion() {
        return idColsulta_llamado_atencion;
    }

    public void setIdColsulta_llamado_atencion(Integer idColsulta_llamado_atencion) {
        this.idColsulta_llamado_atencion = idColsulta_llamado_atencion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
