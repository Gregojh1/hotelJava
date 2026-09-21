package com.hotel.service;

import java.util.List;

import com.hotel.model.entity.Cajero;
import com.hotel.persistence.CrudCajero;

public class CajeroServ {

    public void saveCajero(Cajero cajero){
        CrudCajero cajeroscrud = new CrudCajero();
        List<Cajero> cajeros = cajeroscrud.getAll();
        for (Cajero cajero2 : cajeros) {
            if (cajero2.getNroEmpleado() == cajero.getNroEmpleado()) {
                throw new RuntimeException("el cajero con este numero ya existe");
            }
        }
        cajeroscrud.save(cajero);
    }
 
    
    
}
