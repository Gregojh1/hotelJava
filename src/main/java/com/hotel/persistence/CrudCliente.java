package com.hotel.persistence;

import java.util.List;

import com.hotel.model.entity.Cliente;
import com.hotel.util.jpaUtil;

import jakarta.persistence.EntityManager;

public class CrudCliente extends Crud<Cliente, Integer>{

    private EntityManager em = jpaUtil.getEntityManager();
    @Override
    public void deleteE(Integer id) {
        
        Cliente cliente = getById(id);
        em.remove(cliente);
        System.out.println("cliente borrado");
        


    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clienteList = em.createQuery("Select c from Cliente c", Cliente.class).getResultList();
        return clienteList;
    }

    @Override
    public Cliente getById(Integer id) {
        
        Cliente cliente = em.find(Cliente.class, id);
        if(cliente ==null){
            throw new RuntimeException("cliente no existe");
        }
        return cliente;
    }

    @Override
    public void save(Cliente entity) {
        Integer id = entity.getId();
        if (id==null){
            em.persist(entity);
        }else{
            Cliente cliente = getById(id);
            if(cliente !=null){
                cliente.setNombre(entity.getNombre());
                cliente.setApellido(entity.getApellido());
                cliente.setEmail(entity.getEmail());
                cliente.setMembresia(entity.getMembresia());
                cliente.setTipoDocumento(entity.getTipoDocumento());
                cliente.setNroDocumento(entity.getNroDocumento());
                em.merge(cliente);

            }
        }

        super.save(entity);
    }

    
}
