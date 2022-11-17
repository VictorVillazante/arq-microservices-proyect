package com.example.msmedico.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.msmedico.services.ReservasService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("medico")
public class MedicoController {
    Logger logger=LoggerFactory.getLogger(MedicoController.class);

    private ReservasService reservasService;
    @Autowired
    public MedicoController(ReservasService reservasService){
        this.reservasService=reservasService;
    }

    @RequestMapping(value = "obtenerConsultas",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerConsultas(){
        String res=reservasService.obtenerReservas();
        return new ResponseEntity<Object>("ok "+res,HttpStatus.OK);
    }

}
