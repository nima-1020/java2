//Friend.java
import java.util.*;

public class Friend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of friends (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        HashSet<String> friendSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of friend " + (i + 1) + ": ");
            String name = scanner.nextLine();
            friendSet.add(name);
        }

        ArrayList<String> sortedNames = new ArrayList<>(friendSet);
        Collections.sort(sortedNames);

        System.out.println("\nFriend names in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
//ReqInfo.java
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
