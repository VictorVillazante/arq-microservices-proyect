package com.example.msreserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.msreserva.entities.HojaTraspasoEntity;


public interface RepositoryHojaTraspaso extends PagingAndSortingRepository<HojaTraspasoEntity,Integer>{
    @Query(value="SELECT * FROM hojas_traspaso WHERE id_consultas=?1",nativeQuery=true)
    List<Object> buscarHojasTraspasoDeConsulta(String id_atencion);

    @Query(value = "SELECT ht.id_hoja_traspaso as idTraspaso,e.nombre as especialidad,p.nombre as paciente,m.nombre as medico,ht.traspaso_aceptado_adm as aceptado,p.id_paciente as id_paciente FROM consultas c JOIN atenciones a ON c.id_atencion=a.id_atencion JOIN pacientes p ON c.id_paciente=p.id_paciente JOIN horarios h ON c.id_horario=h.id_horario JOIN estados_consultas ec ON c.id_estado_consulta=ec.id_estado_consulta JOIN consultorios con ON c.id_consultorio=con.id_consultorio JOIN medicos m ON a.id_medico=m.id_medico JOIN especialidades e ON a.id_especialidades=e.id_especialidades JOIN hojas_traspaso ht ON ht.id_consultas=c.id_consultas WHERE c.fecha=?1",nativeQuery = true)
    List<Object> buscarHojasTraspasoFecha(String fecha);
    
}