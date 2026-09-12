package com.hotel.persistence;

import java.util.List;

import com.hotel.model.entity.Reservas;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class CrudReserva extends Crud<Reservas, Integer> {

    EntityManager em = jpaUtil.getEntityManager();

    @Override
    public void deleteE(Integer id) {
        Reservas reserva = getById(id);
        if (reserva != null) {
            em.remove(id);

        }
        throw new RuntimeException("La reserva no existe");
    }

    @Override
    public List<Reservas> getAll() {
        List<Reservas> reservaList = em.createQuery("Select c from Reservas c", Reservas.class).getResultList();
        return reservaList;
    }

    @Override
    public Reservas getById(Integer id) {
        Reservas reserva = em.find(Reservas.class, id);
        return reserva;
    }

    @Override
    public void save(Reservas entity) {
        Integer id = entity.getId();
        if (id == null) {
            em.persist(entity);
        }
        Reservas reserva = getById(id);
        reserva.setCliente(entity.getCliente());
        reserva.setEstado(entity.getEstado());
        reserva.setFechaInicio(entity.getFechaInicio());
        reserva.setFechaFin(entity.getFechaFin());
        reserva.setHabitacion(entity.getHabitacion());
        reserva.setMontoTotal(entity.getMontoTotal());
        em.merge(reserva);
    }

}
