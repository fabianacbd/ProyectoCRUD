package Model;

import jakarta.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_empleado;
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

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String email, int telefono, String tipo_jornada, String puesto, int salario_hora) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipo_jornada = tipo_jornada;
        this.puesto = puesto;
        this.salario_hora = salario_hora;
    }

    public int getId() {
        return id_empleado;
    }

    public void setId(int id) {
        this.id_empleado = id;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado : " +
                " ID: " + id_empleado +
                " Nombre: " + nombre +
                " Email: " + email +
                " Telefono: " + telefono +
                " Cargo: " + puesto +
                " Tipo de jornada: " + tipo_jornada +
                " Salario_hora: " + salario_hora;
    }
}


