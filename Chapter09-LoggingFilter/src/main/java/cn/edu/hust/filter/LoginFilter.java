package cn.edu.hust.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        HttpSession session=req.getSession();
        Object o=session.getAttribute("user");
        if(o==null)
        {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        //放行
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy");
    }
}
