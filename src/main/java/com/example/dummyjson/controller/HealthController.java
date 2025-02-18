package com.example.dummyjson.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    
    // Endpoint simples para verificar a saúde da aplicação, retornando a data e hora atual. 
    
	
	@GetMapping("/health")
    public String health() {
        return LocalDateTime.now().toString();
    }

}
