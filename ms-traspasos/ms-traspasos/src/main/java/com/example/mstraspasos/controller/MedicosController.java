package com.example.mstraspasos.controller;
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

import com.example.mstraspasos.dto.HojasTraspasoDto;
import com.example.mstraspasos.entities.HojaTraspasoEntity;
import com.example.mstraspasos.repository.RepositoryHojaTraspaso;
import com.example.mstraspasos.repository.RepositoryHojaTraspasoJPA;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/medicos")
public class MedicosController {
    @Autowired
    RepositoryHojaTraspasoJPA repositoryHojaTraspasoJPA;
    @Autowired
    RepositoryHojaTraspaso repositoryHojaTraspaso;
    @PostMapping(value = "/hojas-traspaso")
    public @ResponseBody HojaTraspasoEntity registrarHojaTraspaso(@RequestBody HojaTraspasoEntity htn){
        repositoryHojaTraspasoJPA.save(htn);
        return htn;
    }
    @GetMapping(value = "consulta/hojas-traspaso/{id}")
    public @ResponseBody List<Object> obtenerHojasTraspasoConsulta(@PathVariable("id") int id ){
        List<Object>lht=repositoryHojaTraspaso.buscarHojasTraspasoDeConsulta(id+"");
        List<Object>lhtf=new ArrayList<>();
        for(int i=0;i<lht.size();i++){
            Object[]valores=(Object[]) lht.get(i);
            lhtf.add(new HojasTraspasoDto(valores[0],valores[1],valores[2],valores[3]));
        }
        return lhtf;
    }
    @DeleteMapping(value = "hojas-traspaso/{id}")
    public @ResponseBody HojaTraspasoEntity eliminarHojaTraspasoPorId(@PathVariable("id") int id ){
        HojaTraspasoEntity hte=repositoryHojaTraspasoJPA.findById(id).get();
        repositoryHojaTraspasoJPA.delete(hte);
        return hte;
    }
} 
