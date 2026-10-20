package com.hotel.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.hotel.persistence.CrudHabitacion;
import com.hotel.persistence.entity.Habitacion;
import com.hotel.service.HabitacionServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/habitaciones")
public class habitacionesServlet extends HttpServlet {

    private HabitacionServicio habitacionServ = new HabitacionServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-ge
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Habitacion habitacion = new Habitacion();

        habitacion.setNumeroHabitacion(Short.parseShort(req.getParameter("numero_habitacion")));   
        habitacion.setCapacidad(Integer.parseInt(req.getParameter("capacidad")));;
        habitacion.setEstado(req.getParameter("estado"));;
        habitacion.setPrecio(new BigDecimal(req.getParameter("precio")));

        habitacionServ.saveHabitaciones(habitacion);

        req.setAttribute("mensaje", "habitacion guardada");
        req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
        
    }
}
