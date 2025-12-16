package com.demo.app.Services;

import java.util.List;
import com.demo.app.Model.Peliculas;
import com.demo.app.Repositorio.PeliculasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;


@Service
public class PeliculasService {

    @Autowired
    private final PeliculasRepositorio peliculasRepositorio;

    public PeliculasService(PeliculasRepositorio peliculasRepositorio){
        this.peliculasRepositorio = peliculasRepositorio;
    }

    // Crear - actualizar
    public Peliculas crearPelicula(Peliculas pelicula){
        return peliculasRepositorio.save(pelicula);
    }


    public List<Peliculas> getAll() {
        return peliculasRepositorio.findAll();
    }

    public void borrarPelicula(int id_pelicula) {
        peliculasRepositorio.deleteById(id_pelicula);
    }

    //Actualizar completo
    @PutMapping
    public Peliculas actualizarPelicula(int id_pelicula, Peliculas datos){
        Peliculas pelicula = peliculasRepositorio.getById(id_pelicula);

        pelicula.setTitulo(datos.getTitulo());
        pelicula.setId_pelicula(datos.getId_pelicula());
        pelicula.setClasificacion(datos.getClasificacion());
        pelicula.setDirector(datos.getDirector());
        pelicula.setDuracion_minutos(datos.getDuracion_minutos());
        pelicula.setGenero(datos.getGenero());
        pelicula.setPopularidad(datos.getPopularidad());
        pelicula.setFecha_estreno(datos.getFecha_estreno());
        pelicula.setActiva(datos.isActiva());
        return peliculasRepositorio.save(pelicula);
    }

    public Peliculas buscarPorId(int id_pelicula) {
        return (Peliculas) peliculasRepositorio.findById(id_pelicula)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada: " + id_pelicula));
    }



}




