package cn.edu.hust.servlet;

import cn.edu.hust.listener.MyAsyncListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AsyncListenerServlet",urlPatterns = {"/asyncListener"},asyncSupported = true)
public class AsyncListenerServlet extends HttpServlet{
    private static final long serialVersionUID=623738L;

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext=req.startAsync();

        asyncContext.setTimeout(5000);

        //添加异步监听器
        asyncContext.addListener(new MyAsyncListener());

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String greeting="hi from listener";
                System.out.println("wait...");
                req.setAttribute("greeting",greeting);
                asyncContext.dispatch("/test.jsp");
            }
        });
    }
}
