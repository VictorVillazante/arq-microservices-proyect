package com.example.mstraspasos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.mstraspasos.entities.AtencionEntity;


public interface RepositoryAtencion extends PagingAndSortingRepository<AtencionEntity,Integer>{
    @Query(value="SELECT * from atenciones a WHERE a.id_medico=?1 AND a.id_especialidades=?2",nativeQuery=true)
    AtencionEntity listarConsultasMedicoFecha(String id_medico,String id_especialidades);

}
