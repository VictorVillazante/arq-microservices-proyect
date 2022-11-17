package com.example.msreserva.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.msreserva.dto.ConsultasFechaMedico;
import com.example.msreserva.entities.AtencionEntity;
import com.example.msreserva.entities.ConsultasEntity;
import com.example.msreserva.entities.EspecialidadesEntity;
import com.example.msreserva.entities.EstadosConsultaEntity;
import com.example.msreserva.entities.MedicosEntity;
import com.example.msreserva.repository.RepositoryAtencion;
import com.example.msreserva.repository.RepositoryConsultas;
import com.example.msreserva.repository.RepositoryConsultasJPA;
import com.example.msreserva.repository.RepositoryEspecialidadesJPA;
import com.example.msreserva.repository.RepositoryEstadoConsultas;
import com.example.msreserva.repository.RepositoryMedicos;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/medicos")
public class MedicosController {
    @Autowired
    private RepositoryMedicos repositoryMedicos;

    @Autowired
    private RepositoryEspecialidadesJPA repositoryEspecialidadesJPA;

    @Autowired
    private RepositoryAtencion respositoryAtencion;

    @Autowired
    private RepositoryConsultas repositoryConsultas;

    @Autowired
    private RepositoryConsultasJPA repositoryConsultasJPA;
    @GetMapping(path = "/especialidades")
    public @ResponseBody
    List<EspecialidadesEntity> getConsultasPacienteId() {
       
        List<EspecialidadesEntity> listaEspecialidades=repositoryEspecialidadesJPA.findAll();
        
        return listaEspecialidades;
    }
    @GetMapping(path = "/atencion")
    public @ResponseBody Object getAtencion(@RequestParam Map<String, String> customQuery){
        AtencionEntity atencion=respositoryAtencion.listarConsultasMedicoFecha(customQuery.get("id_medico"),customQuery.get("id_especialidades"));
        if(atencion==null){
            return -1;
        }else{
            return atencion.getId_atencion();
        }
        // if(respositoryAtencion.listarConsultasMedicoFecha(customQuery.get("id_medico"),customQuery.get("id_especialidades"))==null){
        //     return -1;
        // }else{
        //     AtencionEntity atencion=respositoryAtencion.listarConsultasMedicoFecha(customQuery.get("id_medico"),customQuery.get("id_especialidades"));
        //     return atencion.getId_atencion();
        // }
    }

    @GetMapping(path = "/especialidades/{id}")
    public @ResponseBody
    List<MedicosEntity> getMedicosPorEspecialidad(@PathVariable("id") Integer id) {
       
        List<MedicosEntity> listaMedicos=repositoryMedicos.listaMedicosDeEspecialidadId(id);
        
        return listaMedicos;
    }
    @GetMapping(value = "/consultas-dia")
    public @ResponseBody List<ConsultasFechaMedico> controllerMethod(@RequestParam Map<String, String> customQuery) {

        System.out.println("Medico" + customQuery.get("id_medico"));
        System.out.println("Fecha" + customQuery.get("fecha"));

        ArrayList<ConsultasFechaMedico> listaConsultas=new ArrayList();
        List<Object>lista= repositoryConsultas.listarConsultasMedicoFecha(customQuery.get("id_medico"),customQuery.get("fecha"));
        for(int i=0;i<lista.size();i++){
            Object[] l=(Object[]) lista.get(i);
            ConsultasFechaMedico cpid=new ConsultasFechaMedico(l[0],l[1],l[2], l[3], l[4],l[5],l[6],l[7]);
            listaConsultas.add(cpid);
        }
        return listaConsultas;
    }
    @Autowired
    RepositoryEstadoConsultas repositoryEstadoConsultas;
    @GetMapping(value = "estados-consultas")
    public @ResponseBody List<EstadosConsultaEntity> obtenerEstadosConsulta(){
        return repositoryEstadoConsultas.findAll();
    }
    
    
    @PutMapping(value = "consulta/detalle/{id}")
    public @ResponseBody ConsultasEntity actualizarDetalleConsulta(@RequestBody Map<String,Object> nuevos,@PathVariable("id")Integer id){
        ConsultasEntity ca=repositoryConsultasJPA.findById(id).get();
        ca.setId_estado_consulta(Integer.parseInt(nuevos.get("id_estado_consulta")+""));
        ca.setInforme_consulta(nuevos.get("informe_consulta")+"");
        repositoryConsultasJPA.save(ca);
        return ca;
    }

   
   
} 
