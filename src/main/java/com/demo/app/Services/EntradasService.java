package com.demo.app.Services;

import com.demo.app.Model.Entradas;
import com.demo.app.Repositorio.EntradasRepositorio;
import com.demo.app.Repositorio.ProyeccionesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EntradasService {

    @Autowired
    private final EntradasRepositorio entradasRepositorio;
    private final ProyeccionesRepositorio proyeccionesRepositorio;

    public EntradasService(EntradasRepositorio entradasRepositorio, ProyeccionesRepositorio proyeccionesRepositorio) {
        this.entradasRepositorio = entradasRepositorio;
        this.proyeccionesRepositorio = proyeccionesRepositorio;
    }

    // Crear - actualizar
    public Entradas crearEntradas(Entradas entradas) {

        return entradasRepositorio.save(entradas);

    }


    public List<Entradas> getAll() {
        return entradasRepositorio.findAll();
    }

    public void borrarEntradas(int id_entradas) {
        entradasRepositorio.deleteById(id_entradas);
    }

    //Actualizar completo
    @PutMapping
    public Entradas actualizarEntrada(int id_entrada, Entradas datos) {
        Entradas entradas = entradasRepositorio.getById(id_entrada);

        entradas.setTitulo(datos.getTitulo());
        entradas.setId_pelicula(datos.getId_pelicula());
        entradas.setId_entrada(datos.getId_entrada());
        entradas.setClasificacion(datos.getClasificacion());
        entradas.setId_sala(datos.getId_sala());
        entradas.setDuracion_minutos(datos.getDuracion_minutos());
        entradas.setId_proyeccion(datos.getId_proyeccion());
        entradas.setFecha_compra(datos.getFecha_compra());
        entradas.setFecha_inicio(datos.getFecha_inicio());
        entradas.setNombre_sala(datos.getNombre_sala());
        return entradasRepositorio.save(entradas);
    }

    public Entradas buscarPorId(int id_entrada) {
        return (Entradas) entradasRepositorio.findById(id_entrada)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada: " + id_entrada));
    }


}