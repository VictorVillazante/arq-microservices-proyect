package com.example.msreserva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ordenes_laboratorio")
@Entity
public class OrdenLaboratorio {
    @Id
    @Column
    int id_orden_laboratorio;
    @Column
    int id_consultas;
    @Column
    String descripcion;
    public OrdenLaboratorio(int id_orden_laboratorio, int id_consultas, String descripcion) {
        this.id_orden_laboratorio = id_orden_laboratorio;
        this.id_consultas = id_consultas;
        this.descripcion = descripcion;
    }
    public OrdenLaboratorio() {
    }
    public int getId_orden_laboratorio() {
        return id_orden_laboratorio;
    }
    public void setId_orden_laboratorio(int id_orden_laboratorio) {
        this.id_orden_laboratorio = id_orden_laboratorio;
    }
    public int getId_consultas() {
        return id_consultas;
    }
    public void setId_consultas(int id_consultas) {
        this.id_consultas = id_consultas;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "OrdenLaboratorio [id_orden_laboratorio=" + id_orden_laboratorio + ", id_consultas=" + id_consultas
                + ", descripcion=" + descripcion + "]";
    }
    
}
