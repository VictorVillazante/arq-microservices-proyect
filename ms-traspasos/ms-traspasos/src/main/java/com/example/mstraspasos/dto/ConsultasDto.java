package com.example.mstraspasos.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class ConsultasDto {
    private int id_consultas;
    private int id_paciente;
    private Date fecha;
    private int id_horario;
    private int id_estado_consulta;
    private int id_consultorio;
    private int id_atencion;
}
    