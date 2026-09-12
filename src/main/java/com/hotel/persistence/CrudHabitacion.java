package com.hotel.persistence;

import java.util.List;

import com.hotel.model.entity.Habitacion;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class CrudHabitacion extends Crud<Habitacion, Integer> {

    EntityManager em = jpaUtil.getEntityManager();

    @Override
    public void deleteE(Integer id) {
        Habitacion habitacion = getById(id);
        if (habitacion != null) {
            em.remove(habitacion);
            System.out.println("la habitacion fue borrada con exito");
        }
        throw new RuntimeException("habitacion no existe ");

    }

    @Override
    public List<Habitacion> getAll() {
        List<Habitacion> habitaciones = em.createQuery("Select c from Habitacion c", Habitacion.class).getResultList();

        return habitaciones;
    }

    @Override
    public Habitacion getById(Integer id) {
        Habitacion habitacion = em.find(Habitacion.class, id);
        if (habitacion != null) {
            return habitacion;
        }
        throw new RuntimeException("habitacion no encontrada");
    }

    @Override
    public void save(Habitacion entity) {
        Integer id = entity.getId();
        if (id != null) {
            Habitacion habitacion = getById(id);
            habitacion.setNroHabitacion(entity.getNroHabitacion());
            habitacion.setPrecioNoche(entity.getPrecioNoche());
            habitacion.setEstado(entity.getEstado());
            ;
            habitacion.setCapacidad(entity.getCapacidad());
        }
        em.persist(entity);
    }

}
