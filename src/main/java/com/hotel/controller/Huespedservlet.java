package com.hotel.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hotel.persistence.entity.Huesped;
import com.hotel.service.HuespedServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns= "/huesped")
public class Huespedservlet extends HttpServlet {
    private Huesped huesped = new Huesped();

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String fecha =req.getParameter("fecha_nacimiento");


        System.out.println("formato de la fehca_--" +  fecha);

        HuespedServicio huespedServicio = new HuespedServicio();

        huesped.setNombre(req.getParameter("nombre"));
        huesped.setApellido(req.getParameter("apellido"));
        huesped.setEmail(req.getParameter("email"));
        huesped.setNumeroDocumento(Long.parseLong(req.getParameter("numero_documento")));
        huesped.setTipoDocumento(req.getParameter("tipo_de_documento"));
        huesped.setRol(req.getParameter("rol"));
        huesped.setPassword(req.getParameter("password"));
        huesped.setDelete(false);
        huesped.setFechaNacimiento(LocalDate.parse(req.getParameter("fecha_nacimiento"),formato));

        huespedServicio.saveHuesped(huesped);
        req.setAttribute("mensaje", "huesped guardado con exito");
        req.getRequestDispatcher("huesped.jsp").forward(req, resp);
        return ;
        



    }


    // public static void main(String[] args) {
    //     String fecha = "08/09/1992";
    //     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //      System.out.println(LocalDate.parse(fecha,formato)); 
        
    // }
    
}
