package com.hotel.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cajero")
public class Cajero {
    @Override
    public String toString() {
        return "Cajero [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nroEmpleado=" + nroEmpleado
                + ", usuario=" + usuario + ", contraseña=" + contrasena + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    @Column(name = "nro_empleado")
    private Integer nroEmpleado;
    private String usuario;
    private String contrasena;

    public Cajero (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroEmpleado() {
        return nroEmpleado;
    }

    public void setNroEmpleado(Integer nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

}
