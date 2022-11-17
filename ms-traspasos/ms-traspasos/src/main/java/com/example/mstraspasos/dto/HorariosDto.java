package com.example.mstraspasos.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class HorariosDto {
    private Object id_horario;
    private Object inicio;
    private Object fin;
    public HorariosDto(Object id_horario, Object inicio, Object fin) {
        this.id_horario = id_horario;
        this.inicio = inicio;
        this.fin = fin;
    }
    public HorariosDto() {
    }

}
