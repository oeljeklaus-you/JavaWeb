package cn.edu.hust;

import cn.edu.hust.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "customerServlet",urlPatterns = {"/showCustomer","/editCustomer","/updateCustomer"})
public class CustomerServlet extends HttpServlet {

    private List<Customer> customers=new ArrayList<Customer>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if(uri.endsWith("/showCustomer"))
            showCustomer(req,resp);
        else if(uri.endsWith("/editCustomer"))
            editCustomer(req,resp);
        else
            updateCustomer(req,resp);
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        Customer customer=customers.get(id-1);
        String name=req.getParameter("name");
        String city=req.getParameter("city");
        System.out.println("name="+name);
        System.out.println("city="+city);
        customer.setName(name);
        customer.setCity(city);
        resp.sendRedirect("/showCustomer");
    }

    private void editCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id=Integer.valueOf(req.getParameter("id"));
        Customer customer=customers.get(id-1);
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/views/updateCustomer.jsp").forward(req,resp);
    }

    private void showCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("customers",customers);
        System.out.println(customers);
        req.getRequestDispatcher("/views/showCustomer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void init() throws ServletException {
        Customer customer1=new Customer(1,"lili","wuhan");
        Customer customer2=new Customer(2,"Mary","tianmen");
        customers.add(customer1);
        customers.add(customer2);
    }
}
