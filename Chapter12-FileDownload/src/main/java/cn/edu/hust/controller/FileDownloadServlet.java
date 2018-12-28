package cn.edu.hust.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "fileDownLoadServlet",urlPatterns = {"/download"})
public class FileDownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out=resp.getOutputStream();

        File file=new File(getServletContext().getRealPath("/")+"/"+"images/论文图.jpg");
        FileInputStream fis=new FileInputStream(file);
        String downloadFile="article.jpg";
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fis);
        byte[] bytes=new byte[1024];
        int len=-1;
        //设置MIME类型
        resp.setContentType("images/jpeg");
        //设置响应头
        resp.addHeader("Content-Disposition","attachment;filename="+downloadFile);
        while((len=bufferedInputStream.read(bytes))!=-1)
        {
            out.write(bytes,0,len);
        }
        if(bufferedInputStream!=null)
            bufferedInputStream.close();
        if(out!=null)
            out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
