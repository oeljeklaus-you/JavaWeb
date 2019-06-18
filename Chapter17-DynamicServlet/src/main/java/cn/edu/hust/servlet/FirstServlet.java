package cn.edu.hust.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet{

    private String name;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter write=resp.getWriter();

        write.println("<html><head><title>First Servlet"+"</title></head><body>"+name);

        write.println("</body></head>");
    }


    public void setName(String name) {
        this.name = name;
    }
}
