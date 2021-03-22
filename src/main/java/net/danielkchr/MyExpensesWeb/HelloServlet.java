package net.danielkchr.MyExpensesWeb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/service")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //System.out.println("test line");

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("login") + " " + request.getParameter("password"));
        //out.println("<h1>" + message + "</h1>");
        //out.println("</body></html>");


        System.out.println(request.getParameter("login"));
    }

    public void destroy() {
    }
}