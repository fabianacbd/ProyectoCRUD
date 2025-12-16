package com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Comprar entrada y ver si hay asientos disponibles para una funcion, crear una tabla para entradacomprada o algo asi, poner limites de entradas (todo en el service)
// Hacer el registro de usuario como admin poner permisos con endpoints

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
