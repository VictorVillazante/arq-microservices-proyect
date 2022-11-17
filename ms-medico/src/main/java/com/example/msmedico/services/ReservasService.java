package com.example.msmedico.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(contextId = "msMedico",name = "ms-reserva")
public interface ReservasService {
    @RequestMapping(value="/reserva/obtenerReservas", method=RequestMethod.GET)
    String obtenerReservas();
    
}
    