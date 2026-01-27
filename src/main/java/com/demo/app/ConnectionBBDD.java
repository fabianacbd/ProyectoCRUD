package com.demo.app;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ConnectionBBDD {
     //MONGODB la conexión y la base de datos
     private static final MongoClient mongoClient =
             MongoClients.create("mongodb://localhost:27017");

    public static MongoCollection<Document> getEmpleadoCollection() {
        return mongoClient
                .getDatabase("cine")
                .getCollection("empleados");
    }
}