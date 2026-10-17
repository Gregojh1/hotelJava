package com.hotel.persistence.entity;

import java.math.BigDecimal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @Column(name = "numero_habitacion")
    private Short numeroHabitacion;
    private Integer capacidad;
    private String estado;
    private BigDecimal precio;

    public Habitacion() {

    }

    public Habitacion(Short numeroHabitacion, Integer capacidad, String estado, BigDecimal precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.capacidad = capacidad;
        this.estado = estado;
        this.precio = precio;
    }

    public Short getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Short numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}
