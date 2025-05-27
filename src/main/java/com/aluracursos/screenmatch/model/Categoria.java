package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime"),
    AVENTURA("Adventure"),
    HORROR("Horror"),
    SCIFI("Sci-Fi");


    private String categoriaOmdb;

    Categoria (String categoriaOmdb){
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text){
        for(Categoria categoria : Categoria.values()){
            if(categoria.categoriaOmdb.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada " + text);
    }
}
