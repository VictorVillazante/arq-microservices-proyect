package com.example.msreserva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "especialidades")
@Entity
public class EspecialidadesEntity {
    @Override
    public String toString() {
        return "EspecialidadesEntity [id_especialidades=" + id_especialidades + ", nombre=" + nombre + "]";
    }
    public EspecialidadesEntity() {
    }
    public EspecialidadesEntity(int id_especialidades, String nombre) {
        this.id_especialidades = id_especialidades;
        this.nombre = nombre;
    }
    @Id
    @Column
    private int id_especialidades;
    @Column
    private String nombre;
    public int getId_especialidades() {
        return id_especialidades;
    }
    public void setId_especialidades(int id_especialidades) {
        this.id_especialidades = id_especialidades;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
