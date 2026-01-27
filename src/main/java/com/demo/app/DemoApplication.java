package com.demo.app;
import com.demo.app.Model.Empleados;
import com.demo.app.ConnectionBBDD;
import com.demo.app.Model.EmpleadosMongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.demo.app.Services.EmpleadoService;


import javax.swing.text.Document;

// Comprar entrada y ver si hay asientos disponibles para una funcion, crear una tabla para entradacomprada o algo asi, poner limites de entradas (todo en el service)
// Hacer el registro de usuario como admin poner permisos con endpoints

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ConnectionBBDD.getConnectionMongo();
        EmpleadosMongo empleadosMongo = new EmpleadosMongo();

        // Llama al metodo para ver los empleados
        empleadosMongo.listarEmpleados();
        // Insertar Empleado
        empleadosMongo.insertEmpleado("Fabiana", 1211, "CEO", 6292935, "fabiana@gmail.com");
        // Actualizar Empleado
        empleadosMongo.actualizarEmpleados("Fabiana", "Fabiola", "fabiola@gmail.com", "fabiola12@gmail.com", 3784749, 362676843);
        // Borrar Empleado
        empleadosMongo.deleteByName("Fabiana");
    }
}
