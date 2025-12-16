package com.demo.app.Repositorio;

import com.demo.app.Model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleados, Integer > {

//    List<Empleado> findByNombre(String nombre);
//
//    Optional<Empleado> findByEmail(String email);
//
//    List<Empleado> findByNombreContaining(String puesto);

}
