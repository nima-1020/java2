//LinkedList.java
import java.io.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class  ReqInfo extends HttpServlet
{
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
   {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String[] Sname = getServletContext().getServletRegistrations().keySet().toArray(new String[0]);
        
        out.println("<html>");
        out.println("<head>Servlet Program</head>");
        out.println("<body>");
        out.println("<h1>Client Information</h1>");
        out.println("<p>IP Address :"+request.getRemoteAddr()+"</p>");
        out.println("<p>Browser Type :"+request.getHeader("User-Agent")+"</p>");
        out.println("<h1>Server Information</h1>");
        out.println("<p>Server OS :"+System.getProperty("os.name")+"</p>");
        out.println("<p>Server Information :"+getServletContext().getServerInfo()+"</p>");
        out.println("<h2>Loaded Servlet</h2>");
        out.println("<ul>");
        for (String sname : Sname)
        {
        	out.println("<li>"+sname+"</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
   }
}
//patient.java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    <table border="1">
        <tr>
            <th>Patient Number</th>
            <th>Patient Name</th>
            <th>Patient Address</th>
            <th>Patient Age</th>
            <th>Patient Disease</th>
        </tr>
        <%@ page import="java.sql.*" %>
        <% 
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                
                // Database connection details
                String url = "jdbc:postgresql://192.168.1.254:5432/";
                String username = "";
                String password = """;
                
                // Establish the database connection
                conn = DriverManager.getConnection(url, username, password);
                
                // SQL query to fetch patient details
                String sql = "SELECT * FROM patient";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                // Iterate over the result set and display patient details
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getString("pno") %></td>
                        <td><%= rs.getString("pname") %></td>
                        <td><%= rs.getString("addr") %></td>
                        <td><%= rs.getString("age") %></td>
                        <td><%= rs.getString("disease") %></td>
                    </tr>
        <% 
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close JDBC objects in finally block
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </table>
</body>
</html>
