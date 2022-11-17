package com.example.mstraspasos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mstraspasos.dto.AdmTraspasosDto;
import com.example.mstraspasos.entities.HojaTraspasoEntity;
import com.example.mstraspasos.repository.RepositoryHojaTraspaso;
import com.example.mstraspasos.repository.RepositoryHojaTraspasoJPA;



@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/adm")
public class AdmController {
    @Autowired
    RepositoryHojaTraspaso repositoryHojaTraspaso;
    @Autowired
    RepositoryHojaTraspasoJPA repositoryHojaTraspasoJPA;

    @GetMapping(value="/hojas-traspaso/{fecha}")
    public @ResponseBody List<Object> obtenerHojasTraspaso(@PathVariable("fecha") String fecha){
        ArrayList<Object> listaTraspasos=new ArrayList();
        List<Object>lista= repositoryHojaTraspaso.buscarHojasTraspasoFecha(fecha);
        for(int i=0;i<lista.size();i++){
            Object[] l=(Object[]) lista.get(i);
            AdmTraspasosDto cpid=new AdmTraspasosDto(l[0],l[1],l[2], l[3],l[4],l[5]);
            listaTraspasos.add(cpid);
        }
        return listaTraspasos;
    }

  

    @PutMapping(value = "/hojas-traspaso/habilitar/{id}")
    public @ResponseBody HojaTraspasoEntity habilitarTraspaso(@PathVariable("id")Integer id_trapaso){
        HojaTraspasoEntity hte=repositoryHojaTraspasoJPA.findById(id_trapaso).get();
        hte.setTraspaso_aceptado_adm(1);
        repositoryHojaTraspasoJPA.save(hte);
        return hte;
    }
    @PutMapping(value = "/hojas-traspaso/deshabilitar/{id}")
    public @ResponseBody HojaTraspasoEntity deshabilitarTraspaso(@PathVariable("id")Integer id_trapaso){
        HojaTraspasoEntity hte=repositoryHojaTraspasoJPA.findById(id_trapaso).get();
        hte.setTraspaso_aceptado_adm(0);
        repositoryHojaTraspasoJPA.save(hte);
        return hte;
    }
}
