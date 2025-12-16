package com.demo.app.Controller;
import com.demo.app.Model.Peliculas;
import com.demo.app.Services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/peliculas")
public class PeliculasController {
        @Autowired
        private final PeliculasService service;

        public PeliculasController(PeliculasService service) {
            this.service = service;
        }

        // Crear
        @PostMapping
        public Peliculas crearPelicula(@RequestBody Peliculas peliculas){
            return service.crearPelicula(peliculas);
        }


        @GetMapping
        public List<Peliculas> getAll(){
            return service.getAll();
        }



        @GetMapping("/{id}")
        public Peliculas getById(@PathVariable("id") int id_pelicula){
            return service.buscarPorId(id_pelicula);
        }


        // UPDATE
        @PutMapping("/{id}")
        public Peliculas actualizar(@PathVariable("id") int id_pelicula, @RequestBody Peliculas datos) {
            return service.actualizarPelicula(id_pelicula, datos);
        }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarPelicula ( @PathVariable("id")  int id_pelicula){
            service.borrarPelicula(id_pelicula);
        }
    }


