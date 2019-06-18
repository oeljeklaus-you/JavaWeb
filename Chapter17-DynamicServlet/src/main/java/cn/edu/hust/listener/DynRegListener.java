package cn.edu.hust.listener;

import cn.edu.hust.servlet.FirstServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class DynRegListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();

        Servlet firstServlet=null;

        try {
            firstServlet=servletContext.createServlet(FirstServlet.class);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        if(firstServlet!=null && firstServlet instanceof FirstServlet){
            ((FirstServlet) firstServlet).setName("Dynamically registed servlet");
        }

        ServletRegistration.Dynamic dynamic=servletContext.addServlet("firstServlet",firstServlet);

        dynamic.addMapping("/dynamic");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
