package com.example.msreserva.dto;

import lombok.Data;

@Data
public class HojasTraspasoDto {
    Object id_hoja_traspaso;
    Object id_consultas;
    Object examen_clinico;
    Object diagnostico_presuntivo;
    public HojasTraspasoDto(Object id_hoja_traspaso, Object id_consultas, Object examen_clinico,
            Object diagnostico_presuntivo) {
        this.id_hoja_traspaso = id_hoja_traspaso;
        this.id_consultas = id_consultas;
        this.examen_clinico = examen_clinico;
        this.diagnostico_presuntivo = diagnostico_presuntivo;
    }
    public HojasTraspasoDto() {
    }
}
