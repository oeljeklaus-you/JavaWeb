package cn.edu.hust;

import cn.edu.hust.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "bookServlet",urlPatterns = {"/showBooks","/login",})
public class BookServlet extends HttpServlet{
    private List<Book> books=new ArrayList<Book>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();
        if(uri.endsWith("/login"))
        {
            req.setAttribute("name","liming");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else if(uri.endsWith("/showBooks"))
        {
            req.setAttribute("books",books);
            req.getRequestDispatcher("/bookList.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void init() throws ServletException {
        Book book1=new Book("1","Netty in Action","Netty初级入门书籍",56.89f);
        Book book2=new Book("2","Netty 进阶之路","Netty进阶的书籍",86.89f);
        Book book3=new Book("3","Spring in Action","Spring学习书籍",126.54f);
        Book book4=new Book("4","SpringBoot in Action","SpringBoot学习书籍",78f);
        Book book5=new Book("5","SpringCloud学习之路","SpringCloud学习书籍",76.23f);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
}
