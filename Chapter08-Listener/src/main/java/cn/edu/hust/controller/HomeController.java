package cn.edu.hust.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "homeController",urlPatterns = {"/homeServlet","/addServlet","/deleteServlet","/modifyServlet"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if(uri.endsWith("/homeServlet"))
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        else if(uri.endsWith("/addServlet"))
        {
            req.getServletContext().setAttribute("add","add");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
        else if(uri.endsWith("/deleteServlet")){
            req.getServletContext().removeAttribute("add");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }else if(uri.endsWith("/modifyServlet"))
        {
            req.getServletContext().setAttribute("add","modify");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}
