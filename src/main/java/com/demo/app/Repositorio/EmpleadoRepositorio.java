package com.demo.app.Repositorio;

import com.demo.app.Model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleados, Long> {

    List<Empleados> findByNombre(String nombre);

    Optional<Empleados> findById(Long id);

    Optional<Empleados> findByEmail(String email);

    List<Empleados> findByPuesto(String puesto);

}
