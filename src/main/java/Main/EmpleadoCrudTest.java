package Main;
import Model.Empleado;
import Services.EmpleadoService;
import org.springframework.boot.CommandLineRunner;

public class EmpleadoCrudTest{
    public CommandLineRunner testCrud(EmpleadoService service) {
        return args -> {
            System.out.println("Probando CRUD:");

            Empleado empleado = new Empleado(1213, "Laura",
                    "laurabarbati@gmail.com",
                    6789800, "CEO", "Mañana", 12);

            Empleado creado = service.crearEmpleado(empleado);

            Empleado lista = (Empleado) service.getAll();

            System.out.println("Nuevo empleado creado: " + creado);
        };
}
}



