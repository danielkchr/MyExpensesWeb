package net.danielkchr.service;

import net.danielkchr.util.DBUtil;
import net.danielkchr.util.DatabaseConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/service")
public class Service extends HttpServlet {
    private String message;

    public void init()
    {
        DBUtil.initialize("jdbc:mysql://localhost:3306/", "myexpansedb", "root", "");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ////System.out.println("test line");
//
        //response.setContentType("text/html");
//
        //// Hello
        PrintWriter out = response.getWriter();
        //out.println(request.getParameter("login") + " " + request.getParameter("password"));
        ////out.println("<h1>" + message + "</h1>");
        ////out.println("</body></html>");
//
//
        //System.out.println(request.getParameter("login"));

        String query = "SELECT * FROM expense";
        DBUtil.executeQuery(query, (PreparedStatement ps) -> {

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                out.println(rs.getInt("expense_id") + rs.getString("expense_date") + rs.getString("expense_time") + rs.getInt("amount") + rs.getString("category") + rs.getString("comment"));
                System.out.println(rs.getInt("expense_id") + rs.getString("expense_date") + rs.getString("expense_time") + rs.getInt("amount") + rs.getString("category") + rs.getString("comment"));
            }
            return null;
        });
    }

    public void destroy() {
    }
}