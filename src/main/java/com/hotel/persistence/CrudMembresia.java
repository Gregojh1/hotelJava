package com.hotel.persistence;

import java.util.List;

import com.hotel.model.entity.Membresia;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class CrudMembresia extends Crud<Membresia, Integer> {
    @Override
    public void deleteE(Integer id) {
        Membresia membresia = getById(id);
        em.remove(membresia);
        System.out.println("membresia borrada");
    }

    @Override
    public List<Membresia> getAll() {
        List<Membresia> membresias = em.createQuery("Select c from Membresia c", Membresia.class).getResultList();
        return membresias;
    }

    @Override
    public Membresia getById(Integer id) {
        Membresia membresia = em.find(Membresia.class, id);
        if (membresia == null) {
            throw new RuntimeException("membresia no existe");
        }
        return membresia;
    }

    @Override
    public void save(Membresia entity) {
        Integer id = entity.getId();
        if (id == null) {
            em.persist(entity);
        } else {
            Membresia membresia = getById(id);
            if (membresia != null) {
                membresia.setEstado(entity.getEstado());
                membresia.setTipoMembresia(entity.getTipoMembresia());
                em.merge(membresia);
            }
        }

    }

    EntityManager em = jpaUtil.getEntityManager();

}
