package com.demo.app.Services;

import java.util.List;
import com.demo.app.Model.Empleados;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;


@Service
public class EmpleadoService {


    @Autowired
    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoService(EmpleadoRepositorio empleadoRepositorio){
        this.empleadoRepositorio = empleadoRepositorio;
    }

    // Crear - actualizar
    public Empleados crearEmpleado(Empleados empleado){
        return empleadoRepositorio.save(empleado);
    }


    public List<Empleados> getAll() {

        return empleadoRepositorio.findAll();
    }

    public void borrarEmpleado(int id_empleado) {
        empleadoRepositorio.deleteById(id_empleado);
    }

    //Actualizar completo
    @PutMapping
    public Empleados actualizarEmpleado(int id_empleado, Empleados datos){
        Empleados empleado = empleadoRepositorio.getById(id_empleado);

        empleado.setNombre(datos.getNombre());
        empleado.setEmail(datos.getEmail());
        empleado.setTelefono(datos.getTelefono());
        empleado.setPuesto(datos.getPuesto());
        empleado.setTipo_jornada(datos.getTipo_jornada());
        empleado.setSalario_hora(datos.getSalario_hora());
        return empleadoRepositorio.save(empleado);
    }

    public Empleados buscarPorId(int id) {
        return empleadoRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
    }



}




