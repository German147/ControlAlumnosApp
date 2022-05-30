package com.escalab.myexample.entity;

import javax.persistence.*;

@Entity
@Table(name = "consultaLlamadoDeAtencion")
@IdClass(ConsultaLlamadoAtencionPK.class)
public class Consulta_Llamado_De_Atencion {

    @Id
    private Consulta consulta;

    @Id
    private Llamados_de_Atencion llamadosdeAtencion;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Llamados_de_Atencion getLlamadosdeAtencion() {
        return llamadosdeAtencion;
    }

    public void setLlamadosdeAtencion(Llamados_de_Atencion llamadosdeAtencion) {
        this.llamadosdeAtencion = llamadosdeAtencion;
    }
}
