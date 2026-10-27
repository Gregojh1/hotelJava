package com.hotel.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.hotel.persistence.CrudHabitacion;
import com.hotel.persistence.entity.Habitacion;
import com.hotel.service.HabitacionServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/habitaciones")
public class HabitacionesServlet extends HttpServlet {

    private HabitacionServicio habitacionServicio = new HabitacionServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("habitaciones", getAll());
        req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        System.out.println("#### la accion es: " + accion);
        Habitacion habitacion = new Habitacion();

        if (accion.equals("guardar")) {
            System.out.println("### paso por aqui el servlet guardar ##");
            habitacion.setCapacidad(Integer.parseInt(req.getParameter("capacidad")));
            habitacion.setEstado(req.getParameter("estado"));
            habitacion.setPrecio(new BigDecimal(req.getParameter("precio")));

            habitacionServicio.saveHabitaciones(habitacion);
            
            req.setAttribute("msm", "habitacion guardada");
            req.setAttribute("habitaciones", getAll());
            req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
            return;
        }else if (accion.equals("update")) {
            Short id = Short.parseShort(req.getParameter("id")) ;

            Habitacion habitacionBD = habitacionServicio.getById(id);
            req.setAttribute("habitacionBD", habitacionBD);
            req.setAttribute("habitaciones", getAll());
            req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
            return ;

        }else if(accion.equals("updatenow")){
            habitacion.setNumeroHabitacion(Short.parseShort(req.getParameter("numero_habitacion")));
            habitacion.setCapacidad(Integer.parseInt(req.getParameter("capacidad")));
            habitacion.setEstado(req.getParameter("estado"));
            habitacion.setPrecio(new BigDecimal(req.getParameter("precio")));
            habitacionServicio.updateHabitaciones(habitacion);
            req.setAttribute("habitaciones", getAll());
            req.setAttribute("msm", "habitacion actualizada");
            req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
            return ;
        }else if(accion.equals("delete")){
            Short id = Short.parseShort(req.getParameter("id")) ;
            habitacionServicio.deliteById(id);
            req.setAttribute("msm", "habitacion eliminada");
            req.setAttribute("habitaciones", habitacionServicio.getAll());
            req.getRequestDispatcher("habitaciones.jsp").forward(req, resp);
            return ;

        }

    }

    private List<Habitacion> getAll() {
        return habitacionServicio.getAll();
    }
}
