package cn.edu.hust.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name="imageServlet",urlPatterns = {"/getImage"})
public class ImageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String basePath=getServletContext().getRealPath("/WEB-INF/images");
        resp.setContentType("images/jpeg");
        resp.addHeader("Content-Disposition","attachment;filename="+id+".jpg");
        File file=new File(basePath+"/"+id+".jpg");
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fis);
        byte[] bytes=new byte[1024];
        int len=-1;
        if(req.getHeader("referer")!=null)
        {
            OutputStream out=resp.getOutputStream();
            while((len=bufferedInputStream.read(bytes))!=-1)
            {
                out.write(bytes,0,len);
            }
            if(out!=null)
                out.close();
        }
        if(bufferedInputStream!=null)
            bufferedInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
