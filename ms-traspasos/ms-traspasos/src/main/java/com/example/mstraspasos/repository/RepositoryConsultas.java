package com.example.mstraspasos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.mstraspasos.entities.ConsultasEntity;


public interface RepositoryConsultas extends PagingAndSortingRepository<ConsultasEntity,Integer>{
    @Query(value="SELECT c.id_consultas,e.nombre as especialidad,m.nombre as medico,p.nombre as paciente,h.inicio,h.fin,c.fecha,ec.nombre as estado,con.nombre as consultorio "+
    "FROM consultas c "+
    "JOIN atenciones a ON c.id_atencion=a.id_atencion "+
    "JOIN pacientes p ON c.id_paciente=p.id_paciente "+
    "JOIN horarios h ON c.id_horario=h.id_horario "+
    "JOIN estados_consultas ec ON c.id_estado_consulta=ec.id_estado_consulta "+
    "JOIN consultorios con ON c.id_consultorio=con.id_consultorio "+
    "JOIN medicos m ON a.id_medico=m.id_medico "+
    "JOIN especialidades e ON a.id_especialidades=e.id_especialidades "+
    "WHERE p.id_paciente= ?1 and ec.id_estado_consulta=1",nativeQuery=true)
    List<Object> listarReservasPacienteId(int id);





    @Query(value="SELECT c.id_consultas,e.nombre as especialidad,p.nombre as paciente,h.inicio,h.fin,con.nombre,ec.id_estado_consulta,ec.nombre as consultorio FROM consultas c JOIN atenciones a ON c.id_atencion=a.id_atencion JOIN pacientes p ON c.id_paciente=p.id_paciente JOIN horarios h ON c.id_horario=h.id_horario JOIN estados_consultas ec ON c.id_estado_consulta=ec.id_estado_consulta JOIN consultorios con ON c.id_consultorio=con.id_consultorio JOIN medicos m ON a.id_medico=m.id_medico JOIN especialidades e ON a.id_especialidades=e.id_especialidades WHERE m.id_medico=?1 AND c.fecha=?2",nativeQuery=true)
    List<Object> listarConsultasMedicoFecha(String string,String fecha);

    @Query(value="SELECT c.id_consultas,e.nombre as especialidad,p.nombre as paciente,h.inicio,h.fin,con.nombre,ec.id_estado_consulta,ec.nombre as consultorio,m.nombre as medico FROM consultas c JOIN atenciones a ON c.id_atencion=a.id_atencion JOIN pacientes p ON c.id_paciente=p.id_paciente JOIN horarios h ON c.id_horario=h.id_horario JOIN estados_consultas ec ON c.id_estado_consulta=ec.id_estado_consulta JOIN consultorios con ON c.id_consultorio=con.id_consultorio JOIN medicos m ON a.id_medico=m.id_medico JOIN especialidades e ON a.id_especialidades=e.id_especialidades WHERE c.fecha=?1",nativeQuery=true)
    List<Object> listarConsultasFecha(String fecha);

    @Query(value="SELECT * from horarios h WHERE h.id_horario NOT IN (SELECT c.id_horario FROM consultas c WHERE fecha=?2 AND c.id_estado_consulta=1 AND c.id_atencion=?1); ",nativeQuery=true)
    List<Object> listarHorariosDisponiblesPorFechaMedicoEspecialidad(String id_atencion,String fecha);


    @Query(value="SELECT c.id_consultas,e.nombre as especialidad,m.nombre as medico,p.nombre as paciente,p.direccion as direccionPaciente,p.telefono as telefonoPaciente,p.CI as CIPaciente,p.foto_carnet as fotoCarnetPaciente, p.foto_carnet_hosp as fotoCarnetHospital,h.inicio,h.fin,c.fecha,ec.nombre as estado,con.nombre as consultorio FROM consultas c JOIN atenciones a ON c.id_atencion=a.id_atencion JOIN pacientes p ON c.id_paciente=p.id_paciente JOIN horarios h ON c.id_horario=h.id_horario JOIN estados_consultas ec ON c.id_estado_consulta=ec.id_estado_consulta JOIN consultorios con ON c.id_consultorio=con.id_consultorio JOIN medicos m ON a.id_medico=m.id_medico JOIN especialidades e ON a.id_especialidades=e.id_especialidades WHERE c.id_consultas=?1",nativeQuery=true)
    List<Object> obtenerTodosDatosConsulta(Integer id);


    
    
}