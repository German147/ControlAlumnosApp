package com.escalab.myexample.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class ConsultaLlamadoAtencionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_llamadoAtencion", nullable = false)
    private Llamados_de_Atencion llamadosdeAtencion;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;


}
