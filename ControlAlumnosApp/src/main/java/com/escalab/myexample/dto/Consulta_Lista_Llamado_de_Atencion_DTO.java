package com.escalab.myexample.dto;

import com.escalab.myexample.entity.Consulta;
import com.escalab.myexample.entity.LlamadosDeAtencion;

import java.util.List;

public class Consulta_Lista_Llamado_de_Atencion_DTO {

    private Consulta consulta;
    private List<LlamadosDeAtencion> llamadosDeAtencionList;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<LlamadosDeAtencion> getLlamadosDeAtencionList() {
        return llamadosDeAtencionList;
    }

    public void setLlamadosDeAtencionList(List<LlamadosDeAtencion> llamadosDeAtencionList) {
        this.llamadosDeAtencionList = llamadosDeAtencionList;
    }
}
