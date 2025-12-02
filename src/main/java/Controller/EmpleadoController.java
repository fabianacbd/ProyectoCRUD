package Controller;
import Model.Empleado;
import Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cines/empleados")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService service;

    public EmpleadoController() {
        this.service = new EmpleadoService();
    }

    // Crear
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        return service.crearEmpleado(empleado);
    }


    @GetMapping
    public List<Empleado> getAll(){
        return service.getAll();
    }

    // READ (todos)
    @GetMapping
    public List<Empleado> leerEmpleados() {
        return service.listarEmpleado();
    }

    @GetMapping("/{id}")
    public Empleado getById(@PathVariable int id_empleado){
        return service.buscarPorId(id_empleado);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable int id_empleado, @RequestBody Empleado datos) {
        return service.actualizarEmpleado(id_empleado, datos);
    }

        // DELETE
        @DeleteMapping("/{id}")
        public void eliminarEmpleado ( @PathVariable int id_empleado){
            service.borrarEmpleado(id_empleado);
        }
    }

