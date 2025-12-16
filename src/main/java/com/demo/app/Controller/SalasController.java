package com.demo.app.Controller;

import com.demo.app.Model.Peliculas;
import com.demo.app.Model.Salas;
import com.demo.app.Services.PeliculasService;
import com.demo.app.Services.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/salas")
    public class SalasController {
        @Autowired
        private final SalasService service;

        public SalasController(SalasService service) {
            this.service = service;
        }

        // Crear
        @PostMapping
        public Salas crearSalas(@RequestBody Salas salas){
            return service.crearSalas(salas);
        }


        @GetMapping
        public List<Salas> getAll(){
            return service.getAll();
        }



        @GetMapping("/{id}")
        public Salas getById(@PathVariable("id") int id_sala){
            return service.buscarPorId(id_sala);
        }


        // UPDATE
        @PutMapping("/{id}")
        public Salas actualizar(@PathVariable("id") int id_sala, @RequestBody Salas datos) {
            return service.actualizarSalas(id_sala, datos);
        }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarSala ( @PathVariable("id")  int id_sala){
            service.borrarSalas(id_sala);
        }
    }

