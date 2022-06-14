package com.escalab.myexample.entity;

import javax.persistence.*;

@Entity
@Table(name = "consultaLlamadoDeAtencion")
@IdClass(ConsultaLlamadoAtencionPK.class)
public class ConsultaLlamadoDeAtencion {

    @Id
    private Consulta consulta;

    @Id
    private LlamadosDeAtencion llamadosdeAtencion;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public LlamadosDeAtencion getLlamadosdeAtencion() {
        return llamadosdeAtencion;
    }

    public void setLlamadosdeAtencion(LlamadosDeAtencion llamadosdeAtencion) {
        this.llamadosdeAtencion = llamadosdeAtencion;
    }
}
