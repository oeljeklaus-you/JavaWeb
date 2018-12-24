package cn.edu.hust.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletReqestListener implements ServletRequestListener{
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest servletRequest=sre.getServletRequest();
        servletRequest.setAttribute("start",System.nanoTime());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest servletRequest=sre.getServletRequest();
        Long start=(Long)servletRequest.getAttribute("start");
        Long end=System.nanoTime();
        System.out.println(((HttpServletRequest)servletRequest).getRequestURI()+"程序执行了:"+(end-start)/1000+"ms");
    }

}
