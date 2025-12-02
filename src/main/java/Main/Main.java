package Main;
//import Main.EmpleadoCrudTest;
import Controller.EmpleadoController;
import Services.EmpleadoService;
import Model.Empleado;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Comprar entrada y ver si hay asientos disponibles para una funcion, crear una tabla para entradacomprada o algo asi, poner limites de entradas (todo en el service)
// Hacer el registro de usuario como admin poner permisos con endpoints

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        EmpleadoController controller = new EmpleadoController();
        EmpleadoService service = new EmpleadoService();
        System.out.println("Probando CRUD:");
        Empleado empleado = new Empleado(1213, "Laura",
                "laurabarbati@gmail.com",
                6789800, "CEO", "Mañana", 12);

        System.out.println("Nuevo empleado: " + empleado);

        Empleado creado = service.crearEmpleado(empleado);

        System.out.println("Nuevo empleado creado: " + creado);

        System.out.println("Empleados: " + controller.leerEmpleados());

        System.out.println("Buscar empleado: ");
        controller.getById(1);
    }
}
