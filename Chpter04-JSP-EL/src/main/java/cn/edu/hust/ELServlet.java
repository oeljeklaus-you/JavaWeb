package cn.edu.hust;

import cn.edu.hust.domain.Address;
import cn.edu.hust.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "elServlet",urlPatterns = {"/elServlet"})
public class ELServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.首先设置地址
        Address address=new Address(1,"中国","湖北","武汉",431700);
        Customer customer=new Customer(1,"Mary",address);

        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
