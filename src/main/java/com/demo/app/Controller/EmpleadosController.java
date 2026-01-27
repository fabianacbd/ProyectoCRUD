package com.demo.app.Controller;
import com.demo.app.Model.Empleados;

import com.demo.app.Repositorio.EmpleadoRepositorio;
import com.demo.app.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {
    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadosController(EmpleadoRepositorio repo) {
        this.empleadoRepositorio = repo;
    }

    @PostMapping
    public Empleados insertarMongo(@RequestBody Empleados empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @GetMapping
    public List<Empleados> listarMongo() {
        return empleadoRepositorio.findAll();
    }


}

// CODIGO ANTERIOR
//    @Autowired
//    private final EmpleadoService service;
//
//    public EmpleadosController(EmpleadoService service) {
//        this.service = service;
//    }
//
//    // Crear
//    @PostMapping
//    public Empleados crearEmpleado(@RequestBody Empleados empleados){
//        return service.crearEmpleado(empleados);
//    }
//
//
//    @GetMapping
//    public List<Empleados> getAll(){
//        return service.getAll();
//    }
//
//
//
//    @GetMapping("/{id}")
//    public Empleados getById(@PathVariable("id") int id_empleado){
//        return service.buscarPorId(id_empleado);
//    }
//
//
//    // UPDATE
//    @PutMapping("/{id}")
//    public Empleados actualizar(@PathVariable("id") int id_empleado, @RequestBody Empleados datos) {
//        return service.actualizarEmpleado(id_empleado, datos);
//    }
//
//        // DELETE
//        @DeleteMapping("/{id}")
//        public void eliminarEmpleado ( @PathVariable("id")  int id_empleado){
//            service.borrarEmpleado(id_empleado);
//        }
//    }


