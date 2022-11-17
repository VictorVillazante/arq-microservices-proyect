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

import com.example.msreserva.dto.ConsultasPacienteId;
import com.example.msreserva.dto.HorariosDto;
import com.example.msreserva.entities.ConsultasEntity;
import com.example.msreserva.repository.RepositoryConsultas;
import com.example.msreserva.repository.RepositoryConsultasJPA;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@CrossOrigin(origins = {"*","http://localhost:4200","http://localhost"})
@Controller
@RequestMapping(path = "/pacientes")
public class PacientesController {
    @Autowired
    private RepositoryConsultas repositoryConsultas;

    @Autowired
    private RepositoryConsultasJPA repositoryConsultasJPA;

    @GetMapping(path = "/reservas/{id}")
    public @ResponseBody
    List<ConsultasPacienteId> getConsultasPacienteId(@PathVariable("id")Integer id) {
        // This returns a JSON or XML with the users
        // ArrayList listaVentasProductosDetalle= cersinjpa.getVentasDetalle();
        // for (O producto: listaVentasProductosDetalle){
        //     VentasAux pva=(VentasAux)producto;
        // }
        ArrayList<ConsultasPacienteId> listaConsultas=new ArrayList();
        List<Object>lista= repositoryConsultas.listarReservasPacienteId(id);
        for(int i=0;i<lista.size();i++){
            Object[] l=(Object[]) lista.get(i);
            ConsultasPacienteId cpid=new ConsultasPacienteId(l[0],l[1],l[2], l[3], l[4],l[5], l[6], l[7],l[8]);
            listaConsultas.add(cpid);
        }
        
        return listaConsultas;
    }

    @DeleteMapping("/consulta/cancelada/{id}")
    public @ResponseBody ConsultasEntity delete(@PathVariable("id")int id){
        Optional<ConsultasEntity> ca= repositoryConsultasJPA.findById(id);
        ConsultasEntity cn=new ConsultasEntity();
        cn.setFecha(ca.get().getFecha());
        cn.setId_atencion(ca.get().getId_atencion());
        cn.setId_consultas(ca.get().getId_consultas());
        cn.setId_consultorio(ca.get().getId_consultorio());
        cn.setId_estado_consulta(5);
        cn.setId_horario(ca.get().getId_horario());
        cn.setId_paciente(ca.get().getId_paciente());
        cn.setInforme_consulta(ca.get().getInforme_consulta());
        
        return repositoryConsultasJPA.save(cn);
    }

    @PostMapping(path = "reservas")
    public @ResponseBody String registrarReserva(@RequestBody ConsultasEntity nuevo){
        repositoryConsultasJPA.save(nuevo);
        return "Ok";
    }

    @PutMapping(path = "reservas/{id}")
    public @ResponseBody ConsultasEntity actualizarReserva(@RequestBody ConsultasEntity nuevo,@PathVariable("id")Integer id){
        Optional<ConsultasEntity> ca= repositoryConsultasJPA.findById(id);
        ConsultasEntity cn=new ConsultasEntity();
        cn.setFecha(nuevo.getFecha());
        cn.setId_atencion(nuevo.getId_atencion());
        cn.setId_consultas(ca.get().getId_consultas());
        cn.setId_consultorio(nuevo.getId_consultorio());
        cn.setId_estado_consulta(nuevo.getId_estado_consulta());
        cn.setId_horario(nuevo.getId_horario());
        cn.setId_paciente(nuevo.getId_paciente());
        cn.setInforme_consulta(nuevo.getInforme_consulta());
        return repositoryConsultasJPA.save(cn);
    }


    
    @GetMapping(value="/consultas-disponibles")
    public @ResponseBody List<HorariosDto>obtenerHorariosDisponibles(@RequestParam Map<String, String> customQuery){
        List<Object> listaConsultas=repositoryConsultas.listarHorariosDisponiblesPorFechaMedicoEspecialidad(customQuery.get("id_atencion"),customQuery.get("fecha"));
        ArrayList<HorariosDto> horariosDisponibles=new ArrayList();

        for(int i=0;i<listaConsultas.size();i++){
            Object[] l=(Object[]) listaConsultas.get(i);
            HorariosDto cpid=new HorariosDto(l[0],l[1],l[2]);
            horariosDisponibles.add(cpid);
        }
        return horariosDisponibles;
    }
}
