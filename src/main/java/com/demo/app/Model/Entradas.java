package com.demo.app.Model;

import jakarta.persistence.*;

import java.time.LocalDate;


    @Entity
    @Table
    public class Entradas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public String id_entrada;
        @Column
        public int id_proyeccion;
        @Column
        public int id_sala;
        @Column
        public String nombre_sala;
        @Column
        public int id_pelicula;
        @Column
        public LocalDate fecha_compra;
        @Column
        public LocalDate fecha_inicio;
        @Column
        public String titulo;
        @Column
        public String clasificacion;
        @Column
        public int duracion_minutos;
        @Column
        public int numeroEntradas;

        public Entradas() {

        }

        public Entradas(String id_entrada, int id_proyeccion, int id_sala, String nombre_sala, int id_pelicula, LocalDate fecha_compra, LocalDate fecha_inicio, String titulo, String clasificacion, int duracion_minutos, int numeroEntradas) {
            this.id_entrada = id_entrada;
            this.id_proyeccion = id_proyeccion;
            this.id_sala = id_sala;
            this.nombre_sala = nombre_sala;
            this.id_pelicula = id_pelicula;
            this.fecha_compra = fecha_compra;
            this.fecha_inicio = fecha_inicio;
            this.titulo = titulo;
            this.clasificacion = clasificacion;
            this.duracion_minutos = duracion_minutos;
            this.numeroEntradas = numeroEntradas;
        }

        public String getId_entrada() {
            return id_entrada;
        }

        public void setId_entrada(String id_entrada) {
            this.id_entrada = id_entrada;
        }

        public int getId_proyeccion() {
            return id_proyeccion;
        }

        public void setId_proyeccion(int id_proyeccion) {
            this.id_proyeccion = id_proyeccion;
        }

        public int getId_sala() {
            return id_sala;
        }

        public void setId_sala(int id_sala) {
            this.id_sala = id_sala;
        }

        public String getNombre_sala() {
            return nombre_sala;
        }

        public void setNombre_sala(String nombre_sala) {
            this.nombre_sala = nombre_sala;
        }

        public int getId_pelicula() {
            return id_pelicula;
        }

        public void setId_pelicula(int id_pelicula) {
            this.id_pelicula = id_pelicula;
        }

        public LocalDate getFecha_compra() {
            return fecha_compra;
        }

        public void setFecha_compra(LocalDate fecha_compra) {
            this.fecha_compra = fecha_compra;
        }

        public LocalDate getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(LocalDate fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getClasificacion() {
            return clasificacion;
        }

        public void setClasificacion(String clasificacion) {
            this.clasificacion = clasificacion;
        }

        public int getNumeroEntradas() {
            return numeroEntradas;
        }

        public void setNumeroEntradas(int numeroEntradas) {
            this.numeroEntradas = numeroEntradas;
        }

        public int getDuracion_minutos() {
            return duracion_minutos;
        }

        public void setDuracion_minutos(int duracion_minutos) {
            this.duracion_minutos = duracion_minutos;
        }

        @Override
        public String toString() {
            return "Entradas{" +
                    "id_entrada=" + id_entrada +
                    ", id_proyeccion=" + id_proyeccion +
                    ", id_sala=" + id_sala +
                    ", nombre_sala='" + nombre_sala + '\'' +
                    ", id_pelicula=" + id_pelicula +
                    ", fecha_compra=" + fecha_compra +
                    ", fecha_inicio=" + fecha_inicio +
                    ", titulo='" + titulo + '\'' +
                    ", clasificacion='" + clasificacion + '\'' +
                    ", duracion_minutos=" + duracion_minutos +
                    ", numeroEntradas=" + numeroEntradas +
                    '}';
        }
    }
