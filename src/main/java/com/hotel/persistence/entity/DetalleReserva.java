package com.hotel.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;
    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "cod_reserva")
    private Reserva reserva;

}
