package cn.edu.hust.controller;

import cn.edu.hust.action.SaveProductAction;
import cn.edu.hust.domain.Product;
import cn.edu.hust.utils.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ControllerServlet",urlPatterns = {"/product_input","/product_save"})
public class ControllerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();

        int lastIndex=uri.lastIndexOf("/");

        String action=uri.substring(lastIndex+1);

        if(action.equals("product_input"))
        {

        }else if(action.equals("product_save"))
        {
            ProductForm productForm=new ProductForm();

            productForm.setName(req.getParameter("name"));

            productForm.setDescription(req.getParameter("description"));

            productForm.setPrice(req.getParameter("price"));

            Product product=new Product();

            product.setName(productForm.getName());

            product.setDescription(productForm.getDescription());

            product.setPrice(Float.parseFloat(productForm.getPrice()));

            SaveProductAction saveProductAction=new SaveProductAction();

            saveProductAction.save(product);

            //store  model in a scope variable for the view
            req.setAttribute("product",product);

        }

        //forward to a view
        String dispatchUrl=null;

        if(action.equals("product_input")){
            dispatchUrl="/jsp/ProductForm.jsp";
        }else if(action.equals("product_save"))
        {
            dispatchUrl="/jsp/ProductDetails.jsp";
        }
        if(dispatchUrl!=null)
        {
            RequestDispatcher rd=req.getRequestDispatcher(dispatchUrl);
            rd.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}
