package com.demo.app.Controller;

import com.demo.app.Model.Empleados;
import com.demo.app.Model.Entradas;
import com.demo.app.Model.Peliculas;
import com.demo.app.Model.Salas;
import com.demo.app.Services.EmpleadoService;
import com.demo.app.Services.EntradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.app.Repositorio.SalasRepositorio;
import com.demo.app.Repositorio.EntradasRepositorio;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/entradas")
    public class EntradasController {
        @Autowired
        private final EntradasService service;
        @Autowired
        private SalasRepositorio salaRepository;
        @Autowired
        private EntradasRepositorio entradaRepository;

        public EntradasController(EntradasService service) {
            this.service = service;
        }



//        Crear
        @PostMapping
        public ResponseEntity<?> crearEntradas(@RequestParam int id_sala, @RequestParam int numeroEntradas) {

            // Comprobamos que la sala existe
            Optional<Salas> salasOptional = salaRepository.findById(id_sala);
            if (salasOptional.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("La sala no existe");
            }
            Salas sala = salasOptional.get();

            // Comprobamos asientos disponibles
            if (numeroEntradas <= 0) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("El numero de entradas debe ser mayor que 0");
            }

            if (sala.getAsientosDisponibles() < numeroEntradas) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("No hay suficientes asientos disponibles");
            }

            // Creamos la entradas
            Entradas entradas = new Entradas();
            entradas.setNumeroEntradas(numeroEntradas);
            entradas.setId_sala(id_sala);
            entradaRepository.save(entradas);

            //Actualizamos los asientos disponibles
            sala.setAsientosDisponibles(
                    sala.getAsientosDisponibles() - numeroEntradas
            );

            salaRepository.save(sala);

            // Recibimos la respuesta OK
            return ResponseEntity.ok(entradas);

        }


        @GetMapping
        public List<Entradas> getAll(){
            return service.getAll();
        }



        @GetMapping("/{id}")
        public Entradas getById(@PathVariable("id") int id_entrada){
            return service.buscarPorId(id_entrada);
        }


        // UPDATE
        @PutMapping("/{id}")
        public Entradas actualizar(@PathVariable("id") int id_entrada, @RequestBody Entradas datos) {
            return service.actualizarEntrada(id_entrada, datos);
        }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarEntrada ( @PathVariable("id")  int id_entrada){
            service.borrarEntradas(id_entrada);
        }
    }


