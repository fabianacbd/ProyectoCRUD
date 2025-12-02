package Repositorio;

import Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer > {

    List<Empleado> findByNombre(String nombre);

    Optional<Empleado> findByEmail(String email);

    List<Empleado> findByNombreContaining(String puesto);

}
