package com.demo.app.Model;
import com.demo.app.Model.Empleados;
import org.bson.Document;



public class EmpleadosMongo {
    public static Document toDocument(Empleados empleado) {
        return new Document()
                .append("id", empleado.getId())
                .append("nombre", empleado.getNombre())
                .append("puesto", empleado.getPuesto())
                .append("email", empleado.getEmail())
                .append("telefono", empleado.getTelefono());
    }
}
