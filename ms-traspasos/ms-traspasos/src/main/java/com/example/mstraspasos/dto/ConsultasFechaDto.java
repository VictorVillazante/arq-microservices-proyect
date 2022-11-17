package com.example.mstraspasos.dto;

import lombok.Data;

@Data
public class ConsultasFechaDto {
    private Object id;
    private Object especialidad;
    private Object paciente;
    private Object inicio;
    private Object fin;
    private Object consultorio;
    private Object id_estado_consulta;
    private Object estado;
    private Object nombreMedico;
    public ConsultasFechaDto(Object id, Object especialidad, Object paciente, Object inicio, Object fin,
            Object consultorio, Object id_estado_consulta, Object estado, Object nombreMedico) {
        this.id = id;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.inicio = inicio;
        this.fin = fin;
        this.consultorio = consultorio;
        this.id_estado_consulta = id_estado_consulta;
        this.estado = estado;
        this.nombreMedico = nombreMedico;
    }
   

    
}
