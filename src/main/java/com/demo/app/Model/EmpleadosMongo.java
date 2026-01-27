package com.demo.app.Model;
import com.demo.app.ConnectionBBDD;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


@MongoDocument(collection = "Empleados")
public class EmpleadosMongo {

    private MongoCollection<Document> getCollection() {
        return ConnectionBBDD.getConnectionMongo().getCollection("Empleados");
    }

    // 1. LISTAR EMPLEADOS
    public void listarEmpleados() {
        MongoCursor<Document> cursor = getCollection().find().iterator();

        System.out.println("Listado de empleados:");
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(
                    doc.getString("nombre") + " " +
                            doc.getString("puesto") + " " +
                            doc.get("email") + " " +
                            doc.getInteger("telefono") + " "
            );
        }
    }

    // 2. BUSCAR POR NOMBRE
    public boolean findByName(String nombre) {
        Document empleado = getCollection()
                .find(Filters.eq("nombre", nombre))
                .first();

        if (empleado != null) {
            System.out.println("El empleado ya existe: " + nombre);
            return true;
        }

        System.out.println("No existe el empleado: " + nombre);
        return false;
    }

    // 3. INSERTAR ALUMNO
    public void insertEmpleado(String nombre, int id, String puesto, int telefono, String email) {

        if (findByName(nombre)) return;

        Document doc = new Document("id", id)
                .append("nombre", nombre)
                .append("puesto", puesto)
                .append("telefono", telefono)
                .append("email", email);

        getCollection().insertOne(doc);

        System.out.println("Empleado insertado: " + nombre);
        listarEmpleados();
    }

    // 4. BORRAR EMPLEADO POR NOMBRE
    public void deleteByName(String nombre) {

        long count = getCollection()
                .deleteOne(Filters.eq("nombre", nombre))
                .getDeletedCount();

        if (count > 0) {
            System.out.println("Empleadp eliminado: " + nombre);
        } else {
            System.out.println("No existe el empleado: " + nombre);
        }

        listarEmpleados();
    }

    // 5. ACTUALIZAR EMPLEADO
    public void actualizarEmpleados(String nombreActual, String nombreNuevo, String email, String emailnuevo, int telefono, int telefononuevo) {

        long updated = getCollection()
                .updateOne(
                        Filters.eq("nombre", nombreActual),
                        Updates.combine(
                                Updates.set("nombre", nombreNuevo),
                                Updates.set("email", email,
                                Updates.set("email", emailnuevo),
                                Updates.set("telefono", telefono), Updates.set("telefono", telefononuevo),
                        )
                ).getModifiedCount();

        if (updated > 0) {
            System.out.println("Empleado actualizado: " + nombreActual + " → " + nombreNuevo);
        } else {
            System.out.println("No existe el empleado: " + nombreActual);
        }

        listarEmpleados();
    }
}
