package com.demo.app.Controller;
import com.demo.app.Model.Empleados;
import com.demo.app.Services.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    private final EmpleadoService service;

    public EmpleadosController(EmpleadoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Empleados>> getAllEmpleados() {
        return ResponseEntity.ok(service.getAllEmpleados());
    }

    @GetMapping("/{id_empleado}")
    public ResponseEntity<Empleados> getEmpleadoById (@PathVariable Long id) {
        Optional<Empleados> empleados = service.getEmpleadoById(id);

        if (empleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleados.get());
    }

    @PostMapping
    public ResponseEntity<Empleados> createEmpleado(@RequestBody Empleados empleados) {
        return new ResponseEntity<>(service.saveEmpleados(empleados), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id_empleado}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        service.deleteEmpleado(id);
        return ResponseEntity.noContent().build();
    }
    }


