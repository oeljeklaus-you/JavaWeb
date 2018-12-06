package cn.edu.hust.controller;

import cn.edu.hust.domain.Product;
import cn.edu.hust.domain.ShoppingItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "shoppingCartServlet",urlPatterns = {"/showProducts","/addProducts","/showCart"})
public class ShoppingCartServlet extends HttpServlet {
    private List<Product> products=new ArrayList<Product>();
    private final String SHOPPING_CART="ShoppingCart";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if(uri.endsWith("/showProducts"))
            showProducts(req,resp);
        else if(uri.endsWith("/addProducts"))
            addProducts(req,resp);
        else if(uri.endsWith("/showCart"))
            showCart(req,resp);
            
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        HashMap<Integer,ShoppingItem> itemHashMap= (HashMap<Integer, ShoppingItem>) session.getAttribute(SHOPPING_CART);
        if(itemHashMap==null)
            itemHashMap=new HashMap<Integer,ShoppingItem>();
        Collection<ShoppingItem> shoppingItems= itemHashMap.values();
        req.setAttribute("shoppingItems",shoppingItems);
        req.getRequestDispatcher("/cartDetail.jsp").forward(req,resp);
    }

    private void addProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        int id=Integer.valueOf(req.getParameter("id"));
        //从session中取出购物车
        HashMap<Integer,ShoppingItem> cart=(HashMap<Integer, ShoppingItem>) session.getAttribute(SHOPPING_CART);
        if(cart==null)
            cart=new HashMap<>();
        if(cart.get(id)==null){
            Product product=products.get(id-1);
            cart.put(id,new ShoppingItem(product,1));
        }
        else
        {
            ShoppingItem shoppingItem=cart.get(id);
            shoppingItem.setQuantity(shoppingItem.getQuantity()+1);
            cart.put(id,shoppingItem);
        }
        //将购物车放入到session中去
        session.setAttribute(SHOPPING_CART,cart);
        session.setMaxInactiveInterval(30*60);
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }

    private void showProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",products);
        req.getRequestDispatcher("/productList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void init() throws ServletException {
        products.add(new Product(1,"iphoneX","iphone首款全面屏手机",5988));
        products.add(new Product(2,"iMac","苹果公司的台式电脑",58999));
        products.add(new Product(3,"MacBookPro","苹果公司的高端系列笔记本",12888));
        products.add(new Product(4,"联想小新系列","联想公司适合青年的笔记本电脑",5899));
        products.add(new Product(5,"小米Mix3","小米公司出品的高端手机",3499));
        products.add(new Product(6,"魅族16","魅族公司的高端系列手机",2899));
    }
}
