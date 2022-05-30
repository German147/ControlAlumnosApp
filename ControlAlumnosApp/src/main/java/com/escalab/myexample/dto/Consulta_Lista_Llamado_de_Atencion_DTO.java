package com.escalab.myexample.dto;

import com.escalab.myexample.entity.Consulta;
import com.escalab.myexample.entity.Llamados_de_Atencion;

import java.util.List;

public class Consulta_Lista_Llamado_de_Atencion_DTO {

    private Consulta consulta;
    private List<Llamados_de_Atencion> llamadosDeAtencionList;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Llamados_de_Atencion> getLlamadosDeAtencionList() {
        return llamadosDeAtencionList;
    }

    public void setLlamadosDeAtencionList(List<Llamados_de_Atencion> llamadosDeAtencionList) {
        this.llamadosDeAtencionList = llamadosDeAtencionList;
    }
}
