package com.example.mstraspasos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "estados_consultas")
@Entity
public class EstadosConsultaEntity {
    @Id
    @Column
    private int id_estado_consulta;
    @Column
    private String nombre;
    public EstadosConsultaEntity(int id_estado_consulta, String nombre) {
        this.id_estado_consulta = id_estado_consulta;
        this.nombre = nombre;
    }
    public EstadosConsultaEntity() {
    }
    public int getId_estado_consulta() {
        return id_estado_consulta;
    }
    public void setId_estado_consulta(int id_estado_consulta) {
        this.id_estado_consulta = id_estado_consulta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
