package cn.edu.hust.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebFilter(filterName = "LoggingFilter",urlPatterns = "/*",initParams = {@WebInitParam(name="logFileName",value="log.txt"),@WebInitParam(name="prefix",value="URI:")})
public class LoggingFilter implements Filter {
    private PrintWriter logger;
    private String prefix;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoggingFilter.doFilter");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        logger.println(new SimpleDateFormat("yyyy-dd-MM HH:mm:ss", Locale.CHINA).format(new Date()).toString()+" "+prefix+httpServletRequest.getRequestURI());
        logger.flush();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix=filterConfig.getInitParameter("prefix");
        String logFileName=filterConfig.getInitParameter("logFileName");
        String appPath=filterConfig.getServletContext().getRealPath("/");
        System.out.println("logFileName:"+logFileName);
        try
        {
            logger=new PrintWriter(new File(appPath,logFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroying filter");
        if(logger!=null)
        {
            logger.close();
        }
    }
}
