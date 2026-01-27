package com.demo.app.Services;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import com.demo.app.ConnectionBBDD;
import com.demo.app.Model.Empleados;
import com.demo.app.Repositorio.EmpleadoRepositorio;
import com.mongodb.client.MongoCollection;
import com.sun.tools.javac.Main;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.bson.Document;



@Service
public class EmpleadoService {

    private final EmpleadoRepositorio empleadoRepositorio;
    // JPA (SQL)
    private MongoCollection<Document> getCollection() {
        return ConnectionBBDD.getConnectionMongo().getCollection("Empleados");
    }

    public EmpleadoService(EmpleadoRepositorio empleadoRepository) {
        this.empleadoRepositorio = empleadoRepository;
    }

    public Empleados crearEmpleado(Empleados empleado) {

        // 1️⃣ Guardar en MySQL/PostgreSQL
        Empleados empleadoSQL = empleadoRepositorio.save(empleado);

        // 2️⃣ Guardar en MongoDB
        Empleados mongo = new Empleados();
        mongo.setNombre(empleadoSQL.getNombre());
        mongo.setEmail(empleadoSQL.getEmail());
        mongo.setTelefono(empleadoSQL.getTelefono());

        empleadoRepositorio.save(mongo);

        return empleadoSQL;
    }



}















//  CODIGO ANTERIOR
//
//
//    @Autowired
//    private final EmpleadoRepositorio empleadoRepositorio;
//
//    public EmpleadoService(EmpleadoRepositorio empleadoRepositorio) {
//        this.empleadoRepositorio = empleadoRepositorio;
//    }
//
//    // Crear - actualizar
//    public Empleados crearEmpleado(Empleados empleado) {
//        return empleadoRepositorio.save(empleado);
//    }
//
//
//    public List<Empleados> getAll() {
//
//        return empleadoRepositorio.findAll();
//    }
//
////    public void borrarEmpleado(int id_empleado) {
////        empleadoRepositorio.deleteById(id_empleado);
////    }
//
//    //Actualizar completo
//    @PutMapping
//    public Empleados actualizarEmpleado(int id_empleado, Empleados datos) {
//        Empleados empleado = empleadoRepositorio.findById();
//
//        empleado.setNombre(datos.getNombre());
//        empleado.setEmail(datos.getEmail());
//        empleado.setTelefono(datos.getTelefono());
//        empleado.setPuesto(datos.getPuesto());
//        empleado.setTipo_jornada(datos.getTipo_jornada());
//        empleado.setSalario_hora(datos.getSalario_hora());
//        return empleadoRepositorio.save(empleado);
//    }
//
//    public Empleados buscarPorId(int id_empleado) {
//        return empleadoRepositorio.findById(id_empleado)
//                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id_empleado));
//    }
//
//    public void insertEmpleado(String nombre, String email, String puesto, int telefono) {
//
////        if (findByName(nombre)) return;
//
//        Document doc = new Document("nombre", nombre)
//                .append("email", email)
//                .append("telefono", telefono)
//                .append("puesto", puesto);
//
//
//        getCollection().insertOne(doc);
//
//        System.out.println("Empleado insertado: " + nombre);
//        listarEmpleados();
//    }
//
//    public void listarEmpleados() {
//        try {
//            // Cargar el archivo desde resources
//            InputStream is = Main.class
//                    .getClassLoader()
//                    .getResourceAsStream("prueba50empleados.json");
//
//            // Verificación obligatoria
//            if (is == null) {
//                throw new RuntimeException("No se encontró el archivo prueba50empleados.json en resources");
//            }
//
//            // Leer el JSON
//            JSONTokener tokener = new JSONTokener(is);
//            JSONArray empleados = new JSONArray(tokener);
//
//            // Recorrer el array
//            for (int i = 0; i < empleados.length(); i++) {
//                JSONObject emp = empleados.getJSONObject(i);
//
//                System.out.println("ID: " + emp.getInt("id"));
//                System.out.println("Nombre: " + emp.getString("nombre"));
//                System.out.println("Puesto: " + emp.getString("puesto"));
//
//                if (emp.isNull("tipo_jornada")) {
//                    System.out.println("   Tipo jornada: NULL");
//                } else {
//                    System.out.println("   Tipo jornada: " + emp.getString("tipo_jornada"));
//                }
//
//                System.out.println("Email: " + emp.getString("email"));
//                System.out.println("Teléfono: " + emp.getString("telefono"));
//                System.out.println("Fecha contratación: " + emp.getString("fecha_contratacion"));
//                System.out.println("Salario por hora: " + emp.getInt("salario_hora"));
//                System.out.println("Activo: " + emp.getBoolean("activo"));
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error procesando el JSON: " + e.getMessage());
//        }
//
//}}
//


    // Actualizar parcial (PATCH)
//    public Empleado patch(int id, Map<String, Objects>){
//
//
//
//}




