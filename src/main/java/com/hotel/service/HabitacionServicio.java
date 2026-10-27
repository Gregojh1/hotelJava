package com.hotel.service;

import java.util.List;

import com.hotel.persistence.CrudHabitacion;
import com.hotel.persistence.entity.Habitacion;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HabitacionServicio {

    private EntityManager manager = jpaUtil.getEntityManager();
    private EntityTransaction transaction;

    private CrudHabitacion repository;

    public HabitacionServicio() {
        
        repository = new CrudHabitacion(manager);
    }

    public void saveHabitaciones(Habitacion habitacion) {
        System.out.println("### paso por aqui servicio guardar");
        transaction = manager.getTransaction();
        transaction.begin();
        repository.save(habitacion);
        transaction.commit();
        
    }

    public void deliteById(Short numberHabitacion){
        transaction = manager.getTransaction();
        transaction.begin();
        repository.deleteE(numberHabitacion);
        transaction.commit();
    }


    
    public void updateHabitaciones(Habitacion habitacion) {
        transaction = manager.getTransaction();
        transaction.begin();
        Habitacion habitacionBD = getById(habitacion.getNumeroHabitacion());
        if (habitacionBD == null) {
            throw new RuntimeException("habitacion no encontrada por el id: " + habitacion.getNumeroHabitacion());
        }
        habitacionBD.setCapacidad(habitacion.getCapacidad());
        habitacionBD.setEstado(habitacion.getEstado());
        habitacionBD.setPrecio(habitacion.getPrecio());
        repository.update(habitacionBD);
        transaction.commit();
    }

    public List<Habitacion> getAll(){
        return repository.getAll();
    }

    public Habitacion getById(Short id){
        
        return repository.getById(id);
       

    }

}
