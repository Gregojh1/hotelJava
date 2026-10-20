package com.hotel.persistence;

import java.util.List;

import com.hotel.persistence.entity.Habitacion;
import com.hotel.persistence.entity.Huesped;
import com.hotel.persistence.repository.Crud;

import jakarta.persistence.EntityManager;

public class CrudHuesped extends Crud<Huesped, Integer> {

    private EntityManager manager;

    public CrudHuesped(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void deleteE(Integer id) {
        // TODO Auto-generated method stub
        super.deleteE(id);
    }

    @Override
    public List<Huesped> getAll() {
        // TODO Auto-generated method stub
        return manager.createQuery("SELECT h FROM Huesped h", Huesped.class).getResultList();
    }

    @Override
    public Huesped getById(Integer id) {
        // TODO Auto-generated method stub
        Huesped huespedBD = manager.find(Huesped.class, id);
        return huespedBD;
    }

    @Override
    public void save(Huesped entity) {
        try {
            manager.persist(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar", e);
        }

    }

        public void update(Huesped entity) {
        try {
            manager.merge(entity);
        } catch (Exception e) {
           manager.getTransaction().rollback();
            throw new RuntimeException("Error al actualizar", e);
        } 
        
    }

}
