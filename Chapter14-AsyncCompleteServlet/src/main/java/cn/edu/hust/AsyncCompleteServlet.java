package cn.edu.hust;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AsyncCompleteServlet extends HttpServlet{
    private static final long serialVersionUID=5812L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final PrintWriter writer=resp.getWriter();

        writer.println("<html><head><title>"+"Async Servlet</title></head>");

        writer.println("<body><div id='progress'></div>");

        final AsyncContext asyncContext=req.startAsync();

        asyncContext.setTimeout(600000);
        System.out.println("main Thread:"+Thread.currentThread());
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread:"+Thread.currentThread());
                //发送进程更新
                for (int i=0;i<10;i++){
                    writer.println("<script>");
                    writer.println("document.getElementById("+"'progress').innerHTML='"+(i*10)+"% complete");
                    writer.println("</script>");
                    writer.flush();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                writer.println("<script>");
                writer.println("document.getElementById("+"'progress').innerHTML='DONE'");
                writer.println("</script>");
                writer.println("</body></html>");

                asyncContext.complete();
            }
        });
    }
}
