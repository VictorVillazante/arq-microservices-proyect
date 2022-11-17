package com.example.mstraspasos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.mstraspasos.entities.MedicosEntity;


public interface RepositoryMedicos extends PagingAndSortingRepository<MedicosEntity,Integer>{
    @Query(value="SELECT m.id_medico,m.nombre FROM atenciones a JOIN medicos m ON a.id_medico=m.id_medico WHERE a.id_especialidades=?1",nativeQuery=true)
    List<MedicosEntity> listaMedicosDeEspecialidadId(int id);
}