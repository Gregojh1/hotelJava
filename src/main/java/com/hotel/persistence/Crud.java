package com.hotel.persistence;

import java.util.List;

public abstract class Crud<E, ID> {
    public List<E> getAll(){
        return null;
    }

    public E getById(ID id){
        return null;
    }

    public void deleteE(ID id){

    }

    public void save(E entity){
        
    }
}
