package com.example.msmedico.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(contextId = "msMedico",name = "ms-reserva")
@Service
public interface ReservasService {
    @RequestMapping(value="/reserva/obtenerReservas", method=RequestMethod.GET)
    Object obtenerConsultas();
    
}
    