package com.escalab.myexample.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "fecha_Consulta")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_alumno"))
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_apoderado", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_apoderado"))
    private Apoderado apoderado;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_profesor"))
    private Profesor profesor;

    @OneToMany(mappedBy = "consulta", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<DetalleConsulta_Apercivimiento> detalleApercivimiento;

    public Consulta() {
    }

    public Consulta(Integer idConsulta, LocalDateTime fecha,
                    Alumno alumno, Apoderado apoderado,
                    Profesor profesor,
                    List<DetalleConsulta_Apercivimiento> detalleApercivimiento) {
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.alumno = alumno;
        this.apoderado = apoderado;
        this.profesor = profesor;
        this.detalleApercivimiento = detalleApercivimiento;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    public List<DetalleConsulta_Apercivimiento> getDetalleApercivimiento() {
        return detalleApercivimiento;
    }

    public void setDetalleApercivimiento(List<DetalleConsulta_Apercivimiento> detalleApercivimiento) {
        this.detalleApercivimiento = detalleApercivimiento;
    }
}
