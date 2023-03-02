package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Car;

import java.io.IOException;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Car car = new Car(req.getParameter("placa"),req.getParameter("modelo"),req.getParameter("marca"));


//        String placa = req.getParameter("placa");
//        String modelo = req.getParameter("modelo");
//        String marca = req.getParameter("marca");

        req.setAttribute("placa", car.getPlaca());
        req.setAttribute("modelo", car.getModelo());
        req.setAttribute("marca", car.getMarca());

        RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

        rd.forward(req, resp);
    }
}
