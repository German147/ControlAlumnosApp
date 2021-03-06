package com.escalab.myexample.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "llamadoDeAtencion")
public class LlamadosDeAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_llamadoAtencion")
    private Integer llamadoDeAtencion_id;

    @Column(name = "numeroDeLlamadosdeAtencion", length = 50)
    private int numeroDeLlamadosdeAtencion;

    @Column(name = "motivo", length = 50)
    private String motivo;

    @Column(name = "TutoresAvisados")
    private boolean estaAvisadoEltutor;

    public Integer getLlamadoDeAtencion_id() {
        return llamadoDeAtencion_id;
    }

    public void setLlamadoDeAtencion_id(Integer llamadoDeAtencion_id) {
        this.llamadoDeAtencion_id = llamadoDeAtencion_id;
    }

    public int getNumeroDeLlamadosdeAtencion() {
        return numeroDeLlamadosdeAtencion;
    }

    public void setNumeroDeLlamadosdeAtencion(int numeroDeLlamadosdeAtencion) {
        this.numeroDeLlamadosdeAtencion = numeroDeLlamadosdeAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isEstaAvisadoEltutor() {
        return estaAvisadoEltutor;
    }

    public void setEstaAvisadoEltutor(boolean estaAvisadoEltutor) {
        this.estaAvisadoEltutor = estaAvisadoEltutor;
    }
}
