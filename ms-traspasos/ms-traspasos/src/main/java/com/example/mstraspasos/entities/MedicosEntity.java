package com.example.mstraspasos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "medicos")
@Entity
public class MedicosEntity {
    @Id
    @Column
    private int id_medico;
    @Column
    private String nombre;
    public MedicosEntity(int id_medico, String nombre) {
        this.id_medico = id_medico;
        this.nombre = nombre;
    }
    public MedicosEntity() {
    }
    public int getId_medico() {
        return id_medico;
    }
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "MedicosEntity [id_medico=" + id_medico + ", nombre=" + nombre + "]";
    }
}