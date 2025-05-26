package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaHuggingFaceHelsinki;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double evaluacion;
    private String poster;
    private Categoria genero;
    private String actores;
    private String sinopsis;

    public Serie(DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalTemporadas = datosSerie.totalTemporadas();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.poster = datosSerie.poster();
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
        this.sinopsis = ConsultaHuggingFaceHelsinki.obtenerTraduccion(datosSerie.sinopsis()); // datosSerie.sinopsis(); // Darle este valor para obtener la traduccion de la API de ChatGPT: ConsultaChatGPT.obtenerTraduccion(datosSerie.sinopsis());
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", genero=" + genero +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'';
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public String getActores() {
        return actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
