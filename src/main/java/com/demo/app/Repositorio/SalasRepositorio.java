package com.demo.app.Repositorio;

import com.demo.app.Model.Entradas;
import com.demo.app.Model.Salas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalasRepositorio extends JpaRepository<Salas, Integer > {
}
