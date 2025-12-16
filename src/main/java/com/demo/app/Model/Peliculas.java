package com.demo.app.Model;
import java.time.LocalDate;


import jakarta.persistence.*;

@Entity
@Table
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_pelicula;
    @Column
    public String titulo;
    @Column
    public int duracion_minutos;
    @Column
    public String genero;
    @Column
    public String clasificacion;
    @Column
    public String director;
    @Column
    public LocalDate fecha_estreno;
    @Column
    public int popularidad;
    @Column
    public boolean activa;

    public Peliculas(){

    }

    public Peliculas(int id_pelicula, String titulo, int duracion_minutos, String genero, String clasificacion, String director, LocalDate fecha_estreno, int popularidad, boolean activa) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.duracion_minutos = duracion_minutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.director = director;
        this.fecha_estreno = fecha_estreno;
        this.popularidad = popularidad;
        this.activa = activa;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "Peliculas: " +
                " id_pelicula: " + id_pelicula +
                " titulo: " + titulo +
                " duracion_minutos: " + duracion_minutos +
                " genero: " + genero +
                " clasificacion: " + clasificacion +
                " director: " + director +
                " fecha_estreno: " + fecha_estreno +
                " popularidad: " + popularidad +
                " activa: " + activa;
    }
}
