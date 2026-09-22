package com.hotel.controller;

import java.io.IOException;

import com.hotel.model.entity.Cliente;
import com.hotel.service.ClienteServ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/registrocliente") 
public class Clienteservlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cliente cliente = new Cliente();

       cliente.setNombre(req.getParameter("nombre"));
       cliente.setApellido(req.getParameter("apellido"));
       cliente.setTipoDocumento(req.getParameter("tipo_documento"));
       cliente.setNroDocumento(Integer.parseInt(req.getParameter("nro_dni")));
       cliente.setEmail(req.getParameter("email"));
       ClienteServ servicio = new ClienteServ();
       servicio.saveCliente(cliente);
       req.setAttribute( "mensaje", "usuario guardado con exito");


       req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
