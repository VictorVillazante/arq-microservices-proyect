package com.example.msreserva.dto;

import lombok.Data;

@Data
public class OrdenLaboratorioDto {
    private Object id_orden_laboratorio;
    private Object id_consultas;
    private Object descripcion;
    public OrdenLaboratorioDto(Object id_orden_laboratorio, Object id_consultas, Object descripcion) {
        this.id_orden_laboratorio = id_orden_laboratorio;
        this.id_consultas = id_consultas;
        this.descripcion = descripcion;
    }
    public OrdenLaboratorioDto() {
    }
}
