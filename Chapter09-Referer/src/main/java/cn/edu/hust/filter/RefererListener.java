package cn.edu.hust.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RdferListener",urlPatterns = {"*.png","*.jpg","*.gif"})
public class RefererListener implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        //通过request来得到referer的值
        String s=req.getHeader("referer");
        System.out.println("referer:"+s);
        if(s==null)
        {
            throw new ServletException("images not availbale");
        }
        else
            filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
