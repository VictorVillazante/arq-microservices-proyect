package com.example.mstraspasos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "pacientes")
@Entity
public class PacienteEntity {
    @Id
    @Column
    int id_paciente;
    @Column
    String nombre;
    @Column
    String direccion;
    @Column
    String telefono;
    @Column
    String CI;
    public PacienteEntity(int id_paciente, String nombre, String direccion, String telefono, String cI) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        CI = cI;
    }
    public PacienteEntity() {
    }
    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCI() {
        return CI;
    }
    public void setCI(String cI) {
        CI = cI;
    }
    @Override
    public String toString() {
        return "PacienteEntity [id_paciente=" + id_paciente + ", nombre=" + nombre + ", direccion=" + direccion
                + ", telefono=" + telefono + ", CI=" + CI + "]";
    }
}
