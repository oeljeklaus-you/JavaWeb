package cn.edu.hust;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AsyncDispatchServlet",urlPatterns = {"/asyncDispatch"},asyncSupported = true)
public class AsyncDispatchServlet extends HttpServlet {
    private static final long serialVersionUID=222L;

    @Override
    protected void doGet(final  HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对于request启动startAsync
        final AsyncContext asyncContext=req.startAsync();
        //设置任务完成时间
        asyncContext.setTimeout(5000);
        req.setAttribute("mainThread",Thread.currentThread().getName());
        //线程睡眠3秒
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                req.setAttribute("workThread",Thread.currentThread().getName());
                //调用dispatch方法转发到页面
                asyncContext.dispatch("/threadName.jsp");
            }
        });


    }
}
