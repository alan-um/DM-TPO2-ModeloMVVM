package com.example.tpo2_modelomvvm.Models;

import java.io.Serializable;

public class Libro implements Serializable {
    private int isbn;
    private String titulo;
    private String autor;
    private int fechaPublicacion;
    private String genero;
    private String descripcion;

    public Libro(int isbn, String titulo, String autor, int fechaPublicacion, String genero, String descripcion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
