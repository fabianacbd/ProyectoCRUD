package com.demo.app.Services;

import com.demo.app.Model.Empleados;
import com.demo.app.Repositorio.EmpleadoMongoRepositorio;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService  {
    private final EmpleadoRepositorio empleadoRepositorio;

    private final EmpleadoMongoRepositorio empleadoMongo;

    public EmpleadoService(EmpleadoRepositorio empleadoRepositorio, EmpleadoMongoRepositorio empleadoMongo) {
        this.empleadoRepositorio = empleadoRepositorio;
        this.empleadoMongo = empleadoMongo;
    }

    public List<Empleados> getAllEmpleados() {
        return empleadoRepositorio.findAll();
    }

    public Optional<Empleados> getEmpleadoById(Long id) {
        return empleadoRepositorio.findById(id);
    }

    public Empleados saveEmpleados(Empleados empleados) {

        empleadoMongo.insertarSoloMongo(empleados);
        return empleadoRepositorio.save(empleados);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepositorio.deleteById(id);
    }

}
