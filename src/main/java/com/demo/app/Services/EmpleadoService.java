package com.demo.app.Services;

import com.demo.app.Model.Empleados;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import com.demo.app.ConnectionBBDD;
import com.demo.app.Model.EmpleadosMongo;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoService(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    // CREATE (SQL + Mongo)
    public Empleados crearEmpleado(Empleados empleado) {

        // Guardar en BD relacional
        Empleados empleadoSQL = empleadoRepositorio.save(empleado);

        //  Guardar en MongoDB
        MongoCollection<Document> collection =
                ConnectionBBDD.getEmpleadoCollection();

        collection.insertOne(
                EmpleadosMongo.toDocument(empleadoSQL)
        );

        return empleadoSQL;
    }

    // READ ALL
    public List<Empleados> getAll() {
        return empleadoRepositorio.findAll();
    }

    // READ BY ID
    public Empleados buscarPorId(String id_empleado) {
        return empleadoRepositorio.findById(id_empleado)
                .orElseThrow(() ->
                        new RuntimeException("Empleado no encontrado: " + id_empleado));
    }

    // UPDATE
    public Empleados actualizarEmpleado(String id_empleado, Empleados datos) {

        Empleados empleado = buscarPorId(id_empleado);

        empleado.setNombre(datos.getNombre());
        empleado.setEmail(datos.getEmail());
        empleado.setTelefono(datos.getTelefono());
        empleado.setPuesto(datos.getPuesto());
        empleado.setTipo_jornada(datos.getTipo_jornada());
        empleado.setSalario_hora(datos.getSalario_hora());

        return empleadoRepositorio.save(empleado);
    }

    // DELETE
    public void borrarEmpleado(String id_empleado) {
        empleadoRepositorio.deleteById(id_empleado);
    }
}
