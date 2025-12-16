package com.demo.app.Model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table
public class Proyecciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_proyeccion;
    @Column
    public int id_pelicula;
    @Column
    public int id_sala;
    @Column
    public LocalDate fecha_hora_inicio;
    @Column
    public int precio;
    @Column
    public LocalDate fecha_hora_fin;
    @Column
    public int asientos_disponibles;

    public Proyecciones(){

    }

    public Proyecciones(int id_proyeccion, int id_pelicula, int id_sala, LocalDate fecha_hora_inicio, int precio, int asientos_disponibles, LocalDate fecha_hora_fin) {
        this.id_proyeccion = id_proyeccion;
        this.id_pelicula = id_pelicula;
        this.id_sala = id_sala;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.precio = precio;
        this.asientos_disponibles = asientos_disponibles;
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public int getId_proyeccion() {
        return id_proyeccion;
    }

    public void setId_proyeccion(int id_proyeccion) {
        this.id_proyeccion = id_proyeccion;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public LocalDate getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(LocalDate fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDate getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(LocalDate fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public int getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public void setAsientos_disponibles(int asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }

    @Override
    public String toString() {
        return "Proyecciones{" +
                "id_proyeccion=" + id_proyeccion +
                ", id_pelicula=" + id_pelicula +
                ", id_sala=" + id_sala +
                ", fecha_hora_inicio=" + fecha_hora_inicio +
                ", precio=" + precio +
                ", fecha_hora_fin=" + fecha_hora_fin +
                ", asientos_disponibles=" + asientos_disponibles +
                '}';
    }
}
