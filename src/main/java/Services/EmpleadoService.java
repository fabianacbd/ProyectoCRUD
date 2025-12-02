package Services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import Model.Empleado;
import Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;


@Service
public class EmpleadoService {


    @Autowired
    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoService(){
        this.empleadoRepositorio = new EmpleadoRepositorio() {
            @Override
            public List<Empleado> findByNombre(String nombre) {
                return List.of();
            }

            @Override
            public Optional<Empleado> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public List<Empleado> findByNombreContaining(String puesto) {
                return List.of();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Empleado> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Empleado> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Empleado> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Empleado getOne(Integer integer) {
                return null;
            }

            @Override
            public Empleado getById(Integer integer) {
                return null;
            }

            @Override
            public Empleado getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Empleado> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Empleado> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Empleado> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<Empleado> findAll() {
                return List.of();
            }

            @Override
            public List<Empleado> findAllById(Iterable<Integer> integers) {
                return List.of();
            }

            @Override
            public <S extends Empleado> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Empleado> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Empleado entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Empleado> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Empleado> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Empleado> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Empleado> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Empleado> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Empleado> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Empleado> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Empleado, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    }

    // Crear - actualizar
    public Empleado crearEmpleado(Empleado empleado){
        return empleadoRepositorio.save(empleado);
    }

    public List<Empleado> listarEmpleado() {
        return empleadoRepositorio.findAll();
    }

    public List<Empleado> getAll() {
        return empleadoRepositorio.findAll();
    }

    public void borrarEmpleado(int id_empleado) {
        empleadoRepositorio.deleteById(id_empleado);
    }

    //Actualizar completo
    @PutMapping
    public Empleado actualizarEmpleado(int id_empleado, Empleado datos){
        Empleado empleado = empleadoRepositorio.getById(id_empleado);

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




