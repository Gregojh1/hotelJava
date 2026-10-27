package com.hotel.persistence;

import java.util.List;

import com.hotel.persistence.entity.Habitacion;
import com.hotel.persistence.repository.Crud;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CrudHabitacion extends Crud<Habitacion, Short> {

    private EntityManager manager;
   

    public CrudHabitacion(EntityManager manager) {
        this. manager = manager;
    }

    @Override
    public void deleteE(Short id) {
        Habitacion habitacionBD= getById(id);
        habitacionBD.setEstado("remove");
    }

    @Override
    public List<Habitacion> getAll() {
        // TODO Auto-generated method stub
         return manager.createQuery("SELECT h FROM Habitacion h WHERE h.estado != 'remove'", Habitacion.class).getResultList();
    }

    @Override
    public void save(Habitacion entity) {
        try {
             System.out.println("### paso por el repositorio guardar");
             manager.persist(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar", e);
        }
       
    }

    public void update(Habitacion entity) {
        try {
            manager.merge(entity);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException("Error al actualizar", e);
        }
        
    }

    @Override
    public Habitacion getById(Short id) {
        Habitacion habitacionBD = manager.find(Habitacion.class, id);
        return habitacionBD;
    }

}
