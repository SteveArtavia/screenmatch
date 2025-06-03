package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Una clase Service se encarga de manejar todos los metodos que trabajan las reglas de negocio
@Service
public class SerieService {
    // Se inyectan las dependencias de los Repository
    @Autowired
    private SerieRepository repository;

    // Se crean metodos que programen las reglas de negocio que posteriormente voy a llamar en los controller para enviar una respuesta al View
    public List<SerieDTO> obtenerTodasLasSeries(){
        return convierteDatos(repository.findAll());
    }

    public List<SerieDTO> obtenerTop5() {
        return convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());
    }

    // Este metodo ejecuta un procesamiento de datos que se repetiria varias veces en cada metodo, asi que lo abstraemos para reutilizarlo y no duplicar codigo
    public List<SerieDTO> convierteDatos(List<Serie> serie){
       return serie.stream()
                // Por cada serie que tengo, quiero crear un nuevo DTO que contenga solo la información que necesito
                .map(s -> new SerieDTO(s.getTitulo(), s.getTotalTemporadas(), s.getEvaluacion(), s.getPoster(), s.getGenero(), s.getActores(), s.getSinopsis()))

                // Convierte los datos nuevamente a una List
                .collect(Collectors.toList());
    }
}
