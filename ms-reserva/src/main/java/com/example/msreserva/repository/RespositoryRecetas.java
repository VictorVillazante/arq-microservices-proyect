package com.example.msreserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.msreserva.entities.RecetasEntity;


public interface RespositoryRecetas extends PagingAndSortingRepository<RecetasEntity,Integer>{
    @Query(value="SELECT * from recetas WHERE id_consultas=?1",nativeQuery=true)
    List<RecetasEntity> listaRecetasPorConsulta(Integer id);

}
