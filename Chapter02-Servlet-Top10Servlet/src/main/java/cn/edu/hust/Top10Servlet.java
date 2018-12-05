package cn.edu.hust;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Top10Servlet extends HttpServlet {
    private List<String> londonAttractions;
    private List<String> parisAttractions;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city=req.getParameter("city");
        if(city!=null&&(city.equals("province")||city.equals("city")))
            showAttributions(req,resp,city);
        else
            showMainPage(req,resp);
    }

    private void showAttributions(HttpServletRequest req, HttpServletResponse resp, String city) throws IOException {
        if(city.equals("province"))
            resp.sendRedirect("/province.jsp");
        else if(city.equals("city"))
            resp.sendRedirect("/city.jsp");

    }

    private void showMainPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/index.jsp");
    }

   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void init() throws ServletException {
        londonAttractions=new ArrayList<String>();
        londonAttractions.add("湖北");
        londonAttractions.add("湖南");
        londonAttractions.add("上海");
        londonAttractions.add("北京");
        londonAttractions.add("福建");
        londonAttractions.add("江苏");
        londonAttractions.add("安徽");
        londonAttractions.add("广东");
        londonAttractions.add("贵州");
        parisAttractions=new ArrayList<String>();
        parisAttractions.add("武汉");
        parisAttractions.add("长沙");
        parisAttractions.add("北京");
        parisAttractions.add("福州");
        parisAttractions.add("南京");
        parisAttractions.add("合肥");
        parisAttractions.add("广州");
        parisAttractions.add("贵阳");
    }
}
