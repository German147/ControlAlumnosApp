package com.escalab.myexample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalleDeLaConsulta")
public class DetalleConsulta_Apercivimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleConsulta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
    private Consulta consulta;

    @Column(name = "motivoDelApercivimiento", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar el motivo del apercivimiento")
    @NotEmpty
    private String motivoDelApercivimiento;

    @Column(name = "accionReparadora", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar la accionReparadora del alumno")
    @NotEmpty
    private String accionReparadora;

    public Integer getIdDetalleConsulta() {
        return idDetalleConsulta;
    }

    public void setIdDetalleConsulta(Integer idDetalleConsulta) {
        this.idDetalleConsulta = idDetalleConsulta;
    }

    public String getMotivoDelApercivimiento() {
        return motivoDelApercivimiento;
    }

    public void setMotivoDelApercivimiento(String motivoDelApercivimiento) {
        this.motivoDelApercivimiento = motivoDelApercivimiento;
    }

    public String getAccionReparadora() {
        return accionReparadora;
    }

    public void setAccionReparadora(String accionReparadora) {
        this.accionReparadora = accionReparadora;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
