package com.demo.app.Repositorio;

import com.demo.app.ConnectionBBDD;
import com.demo.app.Model.Empleados;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoMongoRepositorio {

    private MongoCollection<Document> getCollection() {
        return ConnectionBBDD
                .getConnectionMongo()
                .getCollection("Empleados");
    }

    public void insertarSoloMongo(Empleados empleados) {

        Document doc = new Document("nombre", empleados.getNombre())
                .append("id", empleados.getId())
                .append("puesto", empleados.getPuesto())
                .append("email", empleados.getEmail());

        getCollection().insertOne(doc);

        System.out.println("Guardado exclusivamente en Mongo: " + empleados.getNombre());
    }
}
