package com.demo.app.Model;

import jakarta.persistence.*;

import java.time.LocalDate;


    @Entity
    @Table
    public class Salas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int id_sala;
        @Column
        public String nombre_sala;
        @Column
        public int capacidad;
        @Column
        public String tipo_sala;
        @Column
        public String calidad_sonido;
        @Column
        public boolean activa;
        @Column
        public int asientosDisponibles;

        public Salas(){

        }

        public Salas(int id_sala, String nombre_sala, int capacidad, String tipo_sala, String calidad_sonido, boolean activa, int asientosDisponibles) {
            this.id_sala = id_sala;
            this.nombre_sala = nombre_sala;
            this.capacidad = capacidad;
            this.tipo_sala = tipo_sala;
            this.calidad_sonido = calidad_sonido;
            this.activa = activa;
            this.asientosDisponibles = asientosDisponibles;
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

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public String getTipo_sala() {
            return tipo_sala;
        }

        public void setTipo_sala(String tipo_sala) {
            this.tipo_sala = tipo_sala;
        }

        public String getCalidad_sonido() {
            return calidad_sonido;
        }

        public void setCalidad_sonido(String calidad_sonido) {
            this.calidad_sonido = calidad_sonido;
        }

        public boolean isActiva() {
            return activa;
        }

        public void setActiva(boolean activa) {
            this.activa = activa;
        }

        public int getAsientosDisponibles() {
            return asientosDisponibles;
        }

        public void setAsientosDisponibles(int asientosDisponibles) {
            this.asientosDisponibles = asientosDisponibles;
        }

        @Override
        public String toString() {
            return "Salas{" +
                    "id_sala=" + id_sala +
                    ", nombre_sala='" + nombre_sala + '\'' +
                    ", capacidad=" + capacidad +
                    ", tipo_sala='" + tipo_sala + '\'' +
                    ", calidad_sonido='" + calidad_sonido + '\'' +
                    ", activa=" + activa +
                    ", asientosDisponibles=" + asientosDisponibles +
                    '}';
        }
    }
