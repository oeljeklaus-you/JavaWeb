package cn.edu.hust.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "multipartFileUploaServlet",urlPatterns = {"/multipartFileUpServlet","/doMultipartFileUpServlet"})
@MultipartConfig
public class MultipartFileUploaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/multipleFileUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Part> parts=req.getParts();
        for(Part part:parts)
        {
            String contentType=part.getContentType();
            String sourceFileName=getFileName(part);
            //判断是否是文件域,以及文件是否提交了
            if(contentType!=null&&sourceFileName!=null&&!sourceFileName.isEmpty())
            {
                //获取提交的基本路径
                Path basePath= Paths.get(getServletContext().getRealPath("/")+"/"+"uploadFile");
                //判断路径是否存在，如果不存在就创建目录
                if(!Files.exists(basePath))
                {
                    Files.createDirectory(basePath);
                }
                part.write(basePath.toString()+"/"+sourceFileName+"_"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date()).toString());
            }
        }
        resp.sendRedirect("/success.jsp");
    }

    private String getFileName(Part part) {
        String contentDispositionHeader=part.getHeader("content-disposition");
        String[] keyValues=contentDispositionHeader.split(";");
        for(String element:keyValues)
        {
            if(element.trim().startsWith("filename"))
                return element.substring(element.indexOf("=")+1).trim().replace("\"","");
        }
        return null;
    }
}
