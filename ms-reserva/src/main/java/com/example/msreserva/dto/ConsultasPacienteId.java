package com.example.msreserva.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class ConsultasPacienteId {
    private Object id;
    private Object especialidad;
    private Object medico;
    private Object paciente;
    private Object inicio;
    private Object fin;
    private Object atencion;
    private Object estado;
    private Object consultorio;
    public ConsultasPacienteId(Object id, Object especialidad, Object medico, Object paciente, Object inicio,
            Object fin, Object atencion, Object estado, Object consultorio) {
        this.id = id;
        this.especialidad = especialidad;
        this.medico = medico;
        this.paciente = paciente;
        this.inicio = inicio;
        this.fin = fin;
        this.atencion = atencion;
        this.estado = estado;
        this.consultorio = consultorio;
    }
    
}
