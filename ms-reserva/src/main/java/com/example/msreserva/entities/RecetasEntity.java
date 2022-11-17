package com.example.msreserva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "recetas")
@Entity
public class RecetasEntity {
    @Id
    @Column
    private int id_receta;
    @Column
    private String descripcion;
    @Column
    private int habilitado_recogo;
    @Column
    private int id_consultas;
    @Column
    private String titulo;
    public RecetasEntity(int id_receta, String descripcion, int habilitado_recogo, int id_consultas, String titulo) {
        this.id_receta = id_receta;
        this.descripcion = descripcion;
        this.habilitado_recogo = habilitado_recogo;
        this.id_consultas = id_consultas;
        this.titulo = titulo;
    }
    public RecetasEntity() {
    }
    public int getId_receta() {
        return id_receta;
    }
    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getHabilitado_recogo() {
        return habilitado_recogo;
    }
    public void setHabilitado_recogo(int habilitado_recogo) {
        this.habilitado_recogo = habilitado_recogo;
    }
    public int getId_consultas() {
        return id_consultas;
    }
    public void setId_consultas(int id_consultas) {
        this.id_consultas = id_consultas;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
