package cn.edu.hust.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener{
    private AtomicInteger sessionCounter=new AtomicInteger();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("sessionCounter",sessionCounter);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext servletContext=session.getServletContext();
        AtomicInteger sessionCounter=(AtomicInteger)servletContext.getAttribute("sessionCounter");

        System.out.println("SessionCounter create:"+sessionCounter.incrementAndGet());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext servletContext=session.getServletContext();
        AtomicInteger sessionCounter=(AtomicInteger)servletContext.getAttribute("sessionCounter");

        System.out.println("SessionCounter destroy to:"+sessionCounter.decrementAndGet());

    }
}
