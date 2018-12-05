package cn.edu.hust;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
//这个注解声明一个Servlet,name属性用来提供servlet类的名称,urlPatterns告诉容器使用这个字符串调用Servlet
@WebServlet(name = "MyServlet",urlPatterns = {"/myServlet"},initParams = {@WebInitParam(name="admin",value="root"),@WebInitParam(name="email",value ="xxx@163.com")})
public class MyServlet implements Servlet {
    private transient ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
        System.out.println("Servlet 容器初始化完成。。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName=servletConfig.getServletName();
        //设置返回的数据类型
        servletResponse.setContentType("text/html");
        PrintWriter printWriter=servletResponse.getWriter();
        String adminName=servletConfig.getInitParameter("admin");
        printWriter.write("<html><head><meta charset='utf-8'></head><body>"+servletName+" Hello World"+"</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 销毁。。。。");
    }
}
