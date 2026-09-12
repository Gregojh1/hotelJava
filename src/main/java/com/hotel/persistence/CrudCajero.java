package com.hotel.persistence;

import java.util.List;

import com.hotel.model.entity.Cajero;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class CrudCajero extends  Crud<Cajero, Integer>{

    EntityManager em = jpaUtil.getEntityManager();

    @Override
    public void deleteE(Integer id) {
        Cajero cajero = getById(id);
        if (cajero != null){
            em.remove(cajero);
        }
        throw new RuntimeException("el cajero no existe");
    }

    @Override
    public List<Cajero> getAll() {
        List<Cajero> cajeros = em.createQuery("Select c from Cajero c", Cajero.class).getResultList();
        return cajeros;
    }

    @Override
    public Cajero getById(Integer id) {
        Cajero cajero = em.find(Cajero.class, id);
        return cajero;
    }

    @Override
    public void save(Cajero entity) {
        Integer id = entity.getId();
        if (id == null){
            em.persist(entity);
        }
        Cajero cajero = getById(id);
        cajero.setNombre(entity.getNombre());
        cajero.setApellido(entity.getApellido());
        cajero.setUsuario(entity.getUsuario());
        cajero.setContrasena(entity.getContrasena());
        cajero.setNroEmpleado(entity.getNroEmpleado());
        em.merge(cajero);
    }

    
}
