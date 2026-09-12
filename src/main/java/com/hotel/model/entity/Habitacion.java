package com.hotel.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "habitacion")
public class Habitacion {
    @Override
    public String toString() {
        return "Habitacion [id=" + id + ", nroHabitacion=" + nroHabitacion + ", capacidad=" + capacidad + ", estado="
                + estado + ", precioNoche=" + precioNoche + ", reservas=" + reservas + "]";
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="nro_habitacion")
    private Integer nroHabitacion;
    private Integer capacidad;
    private Boolean estado;
    @Column (name = "precio_noche")
    private Double precioNoche;

    @OneToMany(mappedBy = "habitacion")
    private List<Reservas> reservas;

    public Habitacion (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(Integer nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }

    
}
