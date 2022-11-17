package com.example.msreserva.dto;

import lombok.Data;

@Data
public class AdmTraspasosDto {
  private Object id_traspaso;
  private Object especialidad;
  private Object paciente;
  private Object medico;
  private Object aceptado;
  private Object id_paciente;
  public AdmTraspasosDto(Object id_traspaso, Object especialidad, Object paciente, Object medico, Object aceptado,
      Object id_paciente) {
    this.id_traspaso = id_traspaso;
    this.especialidad = especialidad;
    this.paciente = paciente;
    this.medico = medico;
    this.aceptado = aceptado;
    this.id_paciente = id_paciente;
  }


}
