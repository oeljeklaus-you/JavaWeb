package cn.edu.hust.controller;

import cn.edu.hust.action.SaveProductAction;
import cn.edu.hust.domain.Product;
import cn.edu.hust.dto.ProductForm;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "DispatcherFilter",urlPatterns = {"/*"})
public class DispatcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String uri=request.getRequestURI();

        int lastIndex=uri.lastIndexOf("/");
        //得到请求的uri
        String action=uri.substring(lastIndex+1);
        if(action.equals("product_input"))
        {

        }else if(action.equals("product_save"))
        {
            //create form
            ProductForm productForm=new ProductForm();

            productForm.setName(request.getParameter("name"));

            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            //create model

            Product product=new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(productForm.getPrice());

            SaveProductAction saveProductAction=new SaveProductAction();

            saveProductAction.save(product);

            request.setAttribute("product",product);
        }
        // forward to a view
        String dispatchUrl=null;
        if(action.equals("product_input"))
        {
            dispatchUrl="/jsp/ProductForm.jsp";
        }else if(action.equals("product_save"))
        {
            dispatchUrl="/jsp/ProductDetails.jsp";
        }

        if(dispatchUrl!=null)
        {
            RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
            rd.forward(servletRequest,servletResponse);
        }else{
            //放行静态资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
