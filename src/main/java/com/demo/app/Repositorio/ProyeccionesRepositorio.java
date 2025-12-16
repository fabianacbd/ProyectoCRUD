package com.demo.app.Repositorio;

import com.demo.app.Model.Proyecciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionesRepositorio extends JpaRepository<Proyecciones, Integer > {
}
