package com.hotel;

import java.time.LocalDateTime;

import com.hotel.model.entity.Cajero;
import com.hotel.model.entity.Cliente;
import com.hotel.model.entity.Habitacion;
import com.hotel.model.entity.Membresia;
import com.hotel.model.entity.Reservas;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager em = jpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            
            Cajero cajero = em.find( Cajero.class, 2);
            Membresia membresia = em.find(Membresia.class, 2);

            Membresia membresiaComun = em.find(Membresia.class, 3);

            for( int i =1; i <=1;i+=1){
                Habitacion habitacionNew = new Habitacion();

                habitacionNew.setCapacidad(4);
                habitacionNew.setNroHabitacion(2+i);
                habitacionNew.setPrecioNoche(350.00);
                habitacionNew.setEstado(false);
                em.persist(habitacionNew);

                Cliente clienteNew = new Cliente();
                clienteNew.setApellido("nombre" + i);
                clienteNew.setNombre("apellido" + i);
                clienteNew.setMembresia(membresia);
                clienteNew.setNroDocumento(1000000 + i);
                clienteNew.setEmail("nombreapellido" + i +"@mail.com" );
                clienteNew.setTipoDocumento("dni");
                em.persist(clienteNew);

                Reservas reservaNew = new Reservas();
                reservaNew.setCajero(cajero);
                reservaNew.setEstado("activa");
                reservaNew.setCliente(clienteNew);
                reservaNew.setHabitacion(habitacionNew);
                reservaNew.setMontoTotal(350.00);
                reservaNew.setFechaInicio(LocalDateTime.now().plusDays(2).withHour(9).withMinute(0).withSecond(0));
                reservaNew.setFechaFin(LocalDateTime.now().plusDays(9).withHour(12).withMinute(0).withSecond(0));
                em.persist(reservaNew);
            }

            for(int i = 1; i <=1;i+=1){

                Cliente clienteSin = new Cliente();
                clienteSin.setApellido("reserva" + i);
                clienteSin.setNombre("sin" + i);
                clienteSin.setMembresia(membresiaComun);
                clienteSin.setNroDocumento(2000000 + i);
                clienteSin.setEmail("sinreserva" + i +"@mail.com" );
                clienteSin.setTipoDocumento("dni");
                em.persist(clienteSin);

            }

            em.getTransaction().commit();
            System.out.println("datos guardados en la base de datos ");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
