package com.hotel.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class jpaUtil {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("application");


    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        if(emf!= null && emf.isOpen()){
            emf.close();
        }
    }
}
