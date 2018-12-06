package cn.edu.hust;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        if(cookies!=null)
            for(Cookie cookie:cookies)
                if("username".equals(cookie.getName()))
                {
                    req.getRequestDispatcher("/success.jsp").forward(req,resp);
                    return;
                }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       String passwd=req.getParameter("value");
       Cookie cookie=new Cookie("username",name);
       cookie.setMaxAge(30);
       resp.addCookie(cookie);
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }

}
