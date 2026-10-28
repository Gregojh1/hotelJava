package com.hotel.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hotel.persistence.entity.Huesped;
import com.hotel.service.HuespedServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/huesped")
public class Huespedservlet extends HttpServlet {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.http.HttpSession session = req.getSession();
        HuespedServicio huespedServ = new HuespedServicio();

        List<Huesped> huespedlist = huespedServ.getAll();

        req.setAttribute("huespedes", huespedlist);

        String msm = (String) session.getAttribute("msm");

        if (msm != null) {

            req.setAttribute("msm", msm);
            session.removeAttribute("msm");
        }
        req.getRequestDispatcher("huesped.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.http.HttpSession session = req.getSession();
        

        String fecha = req.getParameter("fecha_nacimiento");

        System.out.println("formato de la fehca_--" + fecha);

        HuespedServicio huespedServicio = new HuespedServicio();
        String accion = req.getParameter("accion");

        if (accion.equalsIgnoreCase("guardar")) {
            Huesped huesped = new Huesped();
            huesped.setNombre(req.getParameter("nombre"));
            huesped.setApellido(req.getParameter("apellido"));
            huesped.setEmail(req.getParameter("email"));
            huesped.setNumeroDocumento(Long.parseLong(req.getParameter("numero_documento")));
            huesped.setTipoDocumento(req.getParameter("tipo_de_documento"));
            huesped.setRol(req.getParameter("rol"));
            huesped.setPassword(req.getParameter("password"));
            huesped.setDelete(false);
            huesped.setFechaNacimiento(LocalDate.parse(req.getParameter("fecha_nacimiento"), formato));

            huespedServicio.saveHuesped(huesped);
            req.getSession().setAttribute("msm", "huesped registrado con exito");
            resp.sendRedirect("huesped");
            return;

        } else if (accion.equalsIgnoreCase("update")) {

            Integer id = Integer.parseInt(req.getParameter("id"));
            Huesped huespedbd =huespedServicio.getbyid(id);
            req.setAttribute("huespedBD", huespedbd);
            req.setAttribute("huespedes", huespedServicio.getAll());
            req.getRequestDispatcher("huesped.jsp").forward(req, resp);
            return ;
            
        }else if (accion.equalsIgnoreCase("delete")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            huespedServicio.deleteHuesped(id);
            session.setAttribute("msm", "el huesped ha sido borrado");
            resp.sendRedirect("huesped");
            return ;
            
        } else if (accion.equalsIgnoreCase("updatenow")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Huesped huesped = huespedServicio.getbyid(id);



            huesped.setNombre(req.getParameter("nombre"));
            huesped.setApellido(req.getParameter("apellido"));
            huesped.setEmail(req.getParameter("email"));
            huesped.setNumeroDocumento(Long.parseLong(req.getParameter("numero_documento")));
            huesped.setTipoDocumento(req.getParameter("tipo_de_documento"));
            huesped.setRol(req.getParameter("rol"));
            huesped.setPassword(req.getParameter("password"));
            huesped.setDelete(false);
            huesped.setFechaNacimiento(LocalDate.parse(req.getParameter("fecha_nacimiento"), formato));
            
            huespedServicio.saveHuesped(huesped);
            req.getSession().setAttribute("msm", "huesped se ha modificado");
            resp.sendRedirect("huesped");
            return;
            
        }

        resp.sendRedirect("huesped");

    }

    // public static void main(String[] args) {
    // String fecha = "08/09/1992";
    // DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // System.out.println(LocalDate.parse(fecha,formato));

    // }

}
