package com.demo.app.Model;
// @OneToMany, @ManyToMany, @JoinTable, @ManyToOne,
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private int telefono;
    @Column
    private String puesto;
    @Column
    private String tipo_jornada;
    @Column
    private int salario_hora;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipo_jornada() {
        return tipo_jornada;
    }

    public void setTipo_jornada(String tipo_jornada) {
        this.tipo_jornada = tipo_jornada;
    }

    public int getSalario_hora() {
        return salario_hora;
    }

    public void setSalario_hora(int salario_hora) {
        this.salario_hora = salario_hora;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "id_empleado=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", puesto='" + puesto + '\'' +
                ", tipo_jornada='" + tipo_jornada + '\'' +
                ", salario_hora=" + salario_hora +
                '}';
    }
}




