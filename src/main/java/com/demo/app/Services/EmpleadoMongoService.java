package com.demo.app.Services;

import com.demo.app.Model.Empleados;
import com.demo.app.Model.EmpleadosMongo;
import com.demo.app.Repositorio.EmpleadoMongoRepositorio;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMongoService {
    private final EmpleadoRepositorio empleadoRepository; // JPA (SQL)
    private final EmpleadoMongoRepositorio empleadoMongoRepositorio;

    public EmpleadoMongoService(EmpleadoRepositorio empleadoRepository,
                           EmpleadoMongoRepositorio empleadoMongoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMongoRepositorio = empleadoMongoRepository;
    }

    public EmpleadosMongo crearEmpleado(EmpleadosMongo empleado) {

        //  Guardar en Postgres
        Empleados empleadosMongo = empleadoMongoRepositorio.save(empleado);

        // Guardar en MongoDB
        EmpleadosMongo mongo = new EmpleadosMongo(1223, "Fabiana", "fabiana@gmail.com", 536823404, "CEO", "Completa", 23);
        mongo.setNombre(empleadosMongo.getNombre());
        mongo.setEmail(empleadosMongo.getEmail());
        mongo.setTelefono(empleadosMongo.getTelefono());

        empleadoMongoRepositorio.save(mongo);

        return empleadosMongo;
    }
}
