package Services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Empleado;
import Conexion.ConexionPostgres;
import Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoService {

    @Autowired
    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoService(EmpleadoRepositorio empleadoRepositorio){
        this.empleadoRepositorio = empleadoRepositorio;
    }

    public Empleado insertarEmpleado(Empleado empleado){
        return empleadoRepositorio.save(empleado);
    }

    public List<Empleado> listarEmpleado() {
        return empleadoRepositorio.findAll();
    }

    public void borrarEmpleado(int id) {
        empleadoRepositorio.deleteById(id);
    }

    public Empleado actualizarEmpleado(int id, Empleado datos){
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setNombre(datos.getNombre());
        empleado.setEmail(datos.getEmail());
        empleado.setTelefono(datos.getTelefono());
        empleado.setPuesto(datos.getPuesto());
        empleado.setTipo_jornada(datos.getTipo_jornada());
        empleado.setSalario_hora(datos.getSalario_hora());
        return empleadoRepositorio.save(empleado);
    }

    public Empleado buscarPorId(int id) {
        return empleadoRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
    }
}




