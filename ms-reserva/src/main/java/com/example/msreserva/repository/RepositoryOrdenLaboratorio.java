package com.example.msreserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.msreserva.entities.OrdenLaboratorio;


public interface RepositoryOrdenLaboratorio extends PagingAndSortingRepository<OrdenLaboratorio,Integer>{
    @Query(value="SELECT * FROM ordenes_laboratorio WHERE id_consultas=?1",nativeQuery=true)
    List<Object> buscarOrdenesLaboratorioDeConsulta(String id_atencion);
    
}