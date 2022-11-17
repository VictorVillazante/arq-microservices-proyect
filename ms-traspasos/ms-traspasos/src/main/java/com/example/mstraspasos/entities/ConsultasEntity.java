package com.example.mstraspasos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "consultas")
@Entity
public class ConsultasEntity {
   

    @Id
    @Column
    private int id_consultas;
    @Column
    private int id_paciente;
    @Column
    private Date fecha;
    @Column
    private int id_horario;
    @Column
    private int id_estado_consulta;
    @Column
    private int id_consultorio;
    @Column
    private int id_atencion;
    @Column
    private String informe_consulta;
    public ConsultasEntity(int id_consultas, int id_paciente, Date fecha, int id_horario, int id_estado_consulta,
            int id_consultorio, int id_atencion, String informe_consulta) {
        this.id_consultas = id_consultas;
        this.id_paciente = id_paciente;
        this.fecha = fecha;
        this.id_horario = id_horario;
        this.id_estado_consulta = id_estado_consulta;
        this.id_consultorio = id_consultorio;
        this.id_atencion = id_atencion;
        this.informe_consulta = informe_consulta;
    }
    public ConsultasEntity() {
    }
    public int getId_consultas() {
        return id_consultas;
    }
    public void setId_consultas(int id_consultas) {
        this.id_consultas = id_consultas;
    }
    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getId_horario() {
        return id_horario;
    }
    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }
    public int getId_estado_consulta() {
        return id_estado_consulta;
    }
    public void setId_estado_consulta(int id_estado_consulta) {
        this.id_estado_consulta = id_estado_consulta;
    }
    public int getId_consultorio() {
        return id_consultorio;
    }
    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }
    public int getId_atencion() {
        return id_atencion;
    }
    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public String getInforme_consulta() {
        return informe_consulta;
    }

    public void setInforme_consulta(String informe_consulta) {
        this.informe_consulta = informe_consulta;
    }

   
}