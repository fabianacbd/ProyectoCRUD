package com.demo.app.Repositorio;

import com.demo.app.Model.EmpleadosMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoMongoRepositorio extends MongoRepository<EmpleadosMongo, String> {
}
