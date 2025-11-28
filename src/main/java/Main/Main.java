package Main;
import Services.EmpleadoService;
import Model.Empleado;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = (ApplicationContext) SpringApplication.run(Main.class, args);




    }
}
