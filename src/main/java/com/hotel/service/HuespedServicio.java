package com.hotel.service;

import java.util.List;

import com.hotel.persistence.CrudHuesped;
import com.hotel.persistence.entity.Habitacion;
import com.hotel.persistence.entity.Huesped;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HuespedServicio {
        private EntityManager manager = Persistence.createEntityManagerFactory("application").createEntityManager();

        private CrudHuesped repository ;

        private EntityTransaction transaction;

        public HuespedServicio(){

            repository = new CrudHuesped(manager);
            

        }

        public void saveHuesped(Huesped huesped) {
        transaction = manager.getTransaction();
        transaction.begin();
        repository.save(huesped);
        transaction.commit();
        
    }

    public Huesped getbyid(Integer id){

        return repository.getById(id);
    }

    public void updateHuesped(Huesped huesped){
        transaction = manager.getTransaction();
        Huesped huespedBD = getbyid(huesped.getId());

        if (huespedBD ==null) {
            throw new RuntimeException("huesped no encontrado por id" + huesped.getId());
            
        }

        huespedBD.setNombre(huesped.getNombre());
        huespedBD.setApellido(huesped.getApellido());
        huespedBD.setNumeroDocumento(huesped.getNumeroDocumento());
        huespedBD.setTipoDocumento(huesped.getTipoDocumento());
        huespedBD.setEmail(huesped.getEmail());
        huespedBD.setPassword(huesped.getPassword());
        huespedBD.setReservas(huesped.getReservas());
        huespedBD.setFechaNacimiento(huesped.getFechaNacimiento());
        huespedBD.setRol(huesped.getRol());

        repository.update(huespedBD);
        transaction.commit();

    }

        public List<Huesped> getAll(){
        return repository.getAll();
    }


    
}
