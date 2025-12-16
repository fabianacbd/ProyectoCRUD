package com.demo.app.Services;

import com.demo.app.Model.Empleados;
import com.demo.app.Model.Salas;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import com.demo.app.Repositorio.SalasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class SalasService {


    @Autowired
    private final SalasRepositorio salasRepositorio;

    public SalasService(SalasRepositorio salasRepositorio){
        this.salasRepositorio = salasRepositorio;
    }

    // Crear - actualizar
    public Salas crearSalas(Salas salas){
        return salasRepositorio.save(salas);
    }


    public List<Salas> getAll() {
        return salasRepositorio.findAll();
    }

    public void borrarSalas(int id_sala) {
        salasRepositorio.deleteById(id_sala);
    }

    //Actualizar completo
    @PutMapping
    public Salas actualizarSalas(int id_sala, Salas datos){
        Salas salas = salasRepositorio.getById(id_sala);

        salas.setNombre_sala(datos.getNombre_sala());
        salas.setTipo_sala(datos.getTipo_sala());
        salas.setId_sala(datos.getId_sala());
        salas.setCapacidad(datos.getCapacidad());
        salas.setActiva(datos.isActiva());
        salas.setCalidad_sonido(datos.getCalidad_sonido());
        return salasRepositorio.save(salas);
    }

    public Salas buscarPorId(int id_sala) {
        return salasRepositorio.findById(id_sala)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada: " + id_sala));
    }
}
