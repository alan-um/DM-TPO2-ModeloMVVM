package com.example.tpo2_modelomvvm.Models;

import android.util.Log;

import com.example.tpo2_modelomvvm.R;

import java.util.ArrayList;

public class RepositorioLibros {
    private ArrayList<Libro> repositorio = new ArrayList<>();

    public RepositorioLibros() {//Hardcodea un repo de libros
        repositorio.add(new Libro(0176,
                "HARRY POTTER Y EL PRISIONERO DE AZKABAN",
                "ROWLING, J. K.",
                2020,
                "Literatura infantil y juvenil",
                "El tercer año de estudios de Harry en Hogwarts se ve amenazado por la fuga de Sirius Black de la prisión de Azkaban. Al parecer, se trata de un peligroso mago que fue cómplice de Lord Voldemort y que intentará vengarse de Harry Potter.",
                R.drawable.harry_potter_y_el_prisionero_de_azkaban));
        repositorio.add(new Libro(0201,
                "LOS JUEGOS DEL HAMBRE",
                "COLLINS, SUZANNE",
                2021,
                "Ciencia ficción clásica",
                "Sin libertad y en la pobreza, nadie puede salir de los límites de su distrito. Sólo una chica de 16 años, Katniss Everdeen, osa desafiar las normas para conseguir comida.",
                R.drawable.los_juegos_del_hambre));
        repositorio.add(new Libro(4724,
                "MARTIN FIERRO",
                "HERNANDEZ, JOSE",
                2019,
                "Poesía guachezca",
                "\"El Gaucho Martín Fierro\" es un poema narrativo de José Hernández que cuenta la historia de un gaucho que, tras ser forzado a unirse al ejército para luchar en la frontera, pierde su familia y su hogar, convirtiéndose en un \"gaucho matrero\" (fuera de la ley) y un símbolo de protesta contra las injusticias sociales y el autoritarismo de la época.",
                R.drawable.martin_fierro));
        repositorio.add(new Libro(2750,
                "LOS DIAS DEL FUEGO",
                "BODOC, LILIANA",
                2018,
                "Fantasía épica e histórica",
                "El Odio no suele debilitarse con las caídas sino al contrario. Se levanta, brutal, y ruge hacia los cuatro puntos cardinales. Pero el Amor tampoco se debilita con las caídas sino al contrario. Se levanta, lastimado, y canta. Ahora las Tierras Antiguas se unen a las Tierras Fértiles para librar una guerra definitiva.",
                R.drawable.los_dias_del_fuego));
    }

    public Libro buscarLibroPorTitulo(String tituloBuscado) {
        for (Libro libro : repositorio) {
            if (libro.getTitulo().contains(tituloBuscado.toUpperCase())) {//Busca la primer coincidencia
                return libro; // Retorna el 1er libro si el título coincide
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public Libro buscarLibroPorIsbn(int isbnBuscado) {
        for (Libro libro : repositorio) {
            if (libro.getIsbn()==isbnBuscado) {
                return libro; // Retorna el libro si el título coincide
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public void mostrarLibros() {
        for (Libro libro : repositorio) {
            Log.d("salida",libro.getTitulo());
        }
    }
}

