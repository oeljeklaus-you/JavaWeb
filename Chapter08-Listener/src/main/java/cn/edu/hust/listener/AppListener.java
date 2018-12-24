package cn.edu.hust.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

@WebListener
public class AppListener implements ServletContextListener{
    //当监听器注册是调用该方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        HashMap<String,String> countries=new HashMap<>();
        countries.put("us","USA");
        countries.put("cn","China");
        servletContext.setAttribute("countries",countries);
    }

    //当ServletContext容器销毁时调用该方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(" ServletContext容器销毁了");
    }
}
