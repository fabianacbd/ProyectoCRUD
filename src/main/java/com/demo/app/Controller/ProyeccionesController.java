package com.demo.app.Controller;

import com.demo.app.Model.Peliculas;
import com.demo.app.Model.Proyecciones;
import com.demo.app.Services.PeliculasService;
import com.demo.app.Services.ProyeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/api/proyecciones")
    public class ProyeccionesController {
        @Autowired
        private final ProyeccionesService service;

        public ProyeccionesController(ProyeccionesService service) {
            this.service = service;
        }

        // Crear
        @PostMapping
        public Proyecciones crearProyecciones(@RequestBody Proyecciones proyecciones){
            return service.crearProyecciones(proyecciones);
        }


        @GetMapping
        public List<Proyecciones> getAll(){
            return service.getAll();
        }



        @GetMapping("/{id}")
        public Proyecciones getById(@PathVariable("id") int id_proyeccion){
            return service.buscarPorId(id_proyeccion);
        }


        // UPDATE
        @PutMapping("/{id}")
        public Proyecciones actualizarProyecciones(@PathVariable("id") int id_proyeccion, @RequestBody Proyecciones datos) {
            return service.actualizarProyecciones(id_proyeccion, datos);
        }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarProyeccion ( @PathVariable("id")  int id_proyeccion){
            service.borrarProyecciones(id_proyeccion);
        }
    }


