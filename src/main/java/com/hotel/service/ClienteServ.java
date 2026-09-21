package com.hotel.service;

import java.util.List;

import com.hotel.model.entity.Cliente;
import com.hotel.model.entity.Membresia;
import com.hotel.persistence.CrudCliente;

public class ClienteServ {

    public Cliente saveCliente(Cliente cliente){
        CrudCliente clientecrud = new CrudCliente();
        Membresia membresia = cliente.getMembresia();

        if (membresia.getTipoMembresia() == null) {
            membresia.setTipoMembresia("comun");

            cliente.setMembresia(membresia);

        }else if (!membresia.getTipoMembresia().equals("comun") || 
        !membresia.getTipoMembresia().equals("vip"))
            {
                membresia.setTipoMembresia("comun");
                cliente.setMembresia(membresia);
        }

        return  null;
    }
    
}
