package com.example.msreserva.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reserva")
public class ReservaController {
    @RequestMapping(value = "obtenerReservas",method = RequestMethod.GET)
    public ResponseEntity<Object>obtenerReservas(){
        return new ResponseEntity<Object>("reservas de ms-reservas",HttpStatus.OK);
    }
}   
