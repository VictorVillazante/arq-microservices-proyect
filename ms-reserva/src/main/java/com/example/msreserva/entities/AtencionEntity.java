package com.example.msreserva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "atenciones")
@Entity
public class AtencionEntity {
    @Id
    @Column
    private int id_atencion;
    @Column
    private int id_medico;
    @Column
    private int id_especialidades;
    @Column
    private double salario_mes;
    @Column
    private int horas_mes;
    @Column
    private int id_consultorio;
    public AtencionEntity() {
    }
    public AtencionEntity(int id_atencion, int id_medico, int id_especialidades, double salario_mes, int horas_mes,
            int id_consultorio) {
        this.id_atencion = id_atencion;
        this.id_medico = id_medico;
        this.id_especialidades = id_especialidades;
        this.salario_mes = salario_mes;
        this.horas_mes = horas_mes;
        this.id_consultorio = id_consultorio;
    }
    public int getId_atencion() {
        return id_atencion;
    }
    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }
    public int getId_medico() {
        return id_medico;
    }
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }
    public int getId_especialidades() {
        return id_especialidades;
    }
    public void setId_especialidades(int id_especialidades) {
        this.id_especialidades = id_especialidades;
    }
    public double getSalario_mes() {
        return salario_mes;
    }
    public void setSalario_mes(double salario_mes) {
        this.salario_mes = salario_mes;
    }
    public int getHoras_mes() {
        return horas_mes;
    }
    public void setHoras_mes(int horas_mes) {
        this.horas_mes = horas_mes;
    }
    public int getId_consultorio() {
        return id_consultorio;
    }
    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

}
