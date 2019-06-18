package cn.edu.hust.controller;

        import javax.servlet.ServletContainerInitializer;
        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRegistration;
        import javax.servlet.annotation.HandlesTypes;
        import java.util.Set;
@HandlesTypes(UserfulServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer{
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("onStartup");

        ServletRegistration registration=servletContext.addServlet("usefulServlet","cn.edu.hust.controller.UserfulServlet");

        registration.addMapping("/useful");

        System.out.println("leaving onStartup");
    }
}
