package com.demo.app.Repositorio;

import com.demo.app.Model.Empleados;
import com.demo.app.Model.Peliculas;
import org.springframework.context.annotation.Configuration;
import com.demo.app.Repositorio.PeliculasRepositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PeliculasRepositorio extends JpaRepository<Peliculas, Integer> {
    List<Peliculas> findAll();

    Peliculas save(Peliculas pelicula);

    void deleteById(int idPelicula);

    Peliculas getById(int idPelicula);

    Optional<Object> findById(int idPelicula);
}
