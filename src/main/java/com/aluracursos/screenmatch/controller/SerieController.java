package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {
// Inyectamos la dependencia del service
    @Autowired
    private SerieService service;

    // Cada controller llama a una funcion de la clase Service que procesa los datos que se solicitan

    // Cuando se accede al endpoint se ejecuta el metodo definido debajo de @GetMapping
    @GetMapping("/series")
    public List<SerieDTO> obtenerTodasLasSeries(){
        return service.obtenerTodasLasSeries();
    }

    @GetMapping("/series/top5")
    public List<SerieDTO> obtenerTop5(){
        return service.obtenerTop5();
    }
}
