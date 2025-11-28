package Controller;
import Model.Empleado;
import Services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    // Crear
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return service.insertarEmpleado(empleado);
    }

    // READ (todos)
    @GetMapping
    public List<Empleado> leerEmpleados() {
        return service.listarEmpleado();
    }


    // UPDATE
    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable int id, @RequestBody Empleado datos) {
        return service.actualizarEmpleado(id, datos);
    }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarEmpleado ( @PathVariable int id){
            service.borrarEmpleado(id);
        }
    }

