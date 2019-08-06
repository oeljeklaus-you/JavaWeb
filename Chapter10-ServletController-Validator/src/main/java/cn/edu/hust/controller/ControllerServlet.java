package cn.edu.hust.controller;

import cn.edu.hust.action.SaveProductAction;
import cn.edu.hust.domain.Product;
import cn.edu.hust.dto.ProductForm;
import cn.edu.hust.utils.ProductValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ControllerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();

        int lastIndex=uri.lastIndexOf("/");
        //得到请求的uri
        String action=uri.substring(lastIndex+1);

        // forward to a view
        String dispatchUrl=null;

        if(action.equals("product_input"))
        {
            dispatchUrl="/jsp/ProductForm.jsp";
        }else if(action.equals("product_save"))
        {
            //create form
            ProductForm productForm=new ProductForm();

            productForm.setName(request.getParameter("name"));

            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            //验证信息
            ProductValidator productValidator=new ProductValidator();
            List<String> errors=productValidator.validate(productForm);
            if(errors.isEmpty())
            {
                //create model

                Product product=new Product();
                product.setName(productForm.getName());
                product.setDescription(productForm.getDescription());
                product.setPrice(Float.valueOf(productForm.getPrice()));

                SaveProductAction saveProductAction=new SaveProductAction();

                saveProductAction.save(product);

                request.setAttribute("product",product);
                dispatchUrl="/jsp/ProductDetails.jsp";
            }

            else{
                request.setAttribute("errors",errors);
                request.setAttribute("productForm",productForm);
                dispatchUrl="/jsp/ProductForm.jsp";
            }
        }

        if(dispatchUrl!=null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
