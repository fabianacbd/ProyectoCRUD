package com.demo.app.Services;

import com.demo.app.Model.Peliculas;
import com.demo.app.Model.Proyecciones;
import com.demo.app.Repositorio.PeliculasRepositorio;
import com.demo.app.Repositorio.ProyeccionesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
// Para entradas  // Para entradas: verificar que el numero de entradas sea menor que el numero de asientos disponibles
//            //verificar que existen, si se hace la compra se actualiza el numero de asientos disponibles en sala

    @Service
    public class ProyeccionesService {

        @Autowired
        private final ProyeccionesRepositorio proyeccionesRepositorio;

        public ProyeccionesService(ProyeccionesRepositorio proyeccionesRepositorio){
            this.proyeccionesRepositorio = proyeccionesRepositorio;
        }

        // Crear - actualizar
        public Proyecciones crearProyecciones(Proyecciones proyecciones){

            return proyeccionesRepositorio.save(proyecciones);

        }


        public List<Proyecciones> getAll() {
            return proyeccionesRepositorio.findAll();
        }

        public void borrarProyecciones(int id_proyeccion) {
            proyeccionesRepositorio.deleteById(id_proyeccion);
        }

        //Actualizar completo
        @PutMapping
        public Proyecciones actualizarProyecciones(int id_proyeccion, Proyecciones datos){
            Proyecciones proyecciones = proyeccionesRepositorio.getById(id_proyeccion);

            proyecciones.setId_proyeccion(datos.getId_pelicula());
            proyecciones.setId_pelicula(datos.getId_pelicula());
            proyecciones.setFecha_hora_fin(datos.getFecha_hora_fin());
            proyecciones.setPrecio(datos.getPrecio());
            proyecciones.setAsientos_disponibles(datos.getAsientos_disponibles());
            proyecciones.setId_sala(datos.getId_sala());
            proyecciones.setFecha_hora_inicio(datos.getFecha_hora_inicio());
            return proyeccionesRepositorio.save(proyecciones);
        }

        public Proyecciones buscarPorId(int id_proyeccion) {
            return (Proyecciones) proyeccionesRepositorio.findById(id_proyeccion)
                    .orElseThrow(() -> new RuntimeException("Proyeccion no encontrada: " + id_proyeccion));
        }


    }
