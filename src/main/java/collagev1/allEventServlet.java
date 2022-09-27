package collagev1;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet ("/allEventServlet")
public class allEventServlet extends HttpServlet {
	

	 public ResultSet rs;
	public void service(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		HttpSession sess=request.getSession();
		PrintWriter out = response.getWriter();
		int registerID=0;
		
		try {
			try {
		 registerID=(int) sess.getAttribute("hello");
			}catch(Exception e)
			{
				String errormsg=" Need to Login First";	
				request.setAttribute("error",errormsg);
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
				rd.forward(request,response);
			}
		String query="select * from eventlist;";	
		String db="student";
		Connection con=database.connect(db);
		Statement st=con.createStatement();
		//PreparedStatement st=con.prepareStatement(query);
		//st.setInt(1,registerID);
		ResultSet rs=st.executeQuery(query);
		
		out.print("<!doctype html>\r\n"
				+ "<html lang='en'>\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset='utf-8'>\r\n"
				+ "    <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
				+ "    <title>my event</title>\r\n"
				+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT' crossorigin='anonymous'>\r\n"
				+ "  </head>\r\n"
				+ "  <body>");
		out.println(" <a href=\"home.jsp\">Back home</a>");
		int i=1;
		out.println("<h1>All event</h1>");
		if(request.getAttribute("error")!=null) {
		out.print(request.getAttribute("error"));
		}
		
		if(!rs.next()) {
			out.print("No event Found");
		}
			
					do {
			int eventID =Integer.parseInt( rs.getString(10));
			out.print("<div class=\"card\">\r\n"
					+ "  <div class=\"card-body\">");
			out.println();
			out.println("<p> <h3> Event Id");
			out.println(" "+eventID+"<br> ");
			out.println(" </h3></p> ");
			out.print("<b>registerID  </b> "+rs.getInt(1)+"<br> ");
			
			out.print("<b>name  </b> "+rs.getString(2)+"<br> ");
			out.print("<b>Event Name  </b>  "+rs.getString(3)+"<br> ");
			out.print("<b>College  </b>  "+rs.getString(4)+"<br> ");
			out.print("<b>Persion Incharge  </b>  "+rs.getString(5)+"<br> ");
			
			out.print("<b>Department  </b>  "+rs.getString(6)+"<br> ");
			
			out.print("<b>Event Detail  </b>"+rs.getString(7)+"<br> ");
			out.print("<b>Upload Date</b>  "+rs.getString(8)+"<br> ");
			out.println("<b>Time</b>  "+rs.getString(9)+"<br> ");
		
			
			
			
			out.println("<a href='viewEventServlet?eventID="+eventID+"'>view</a>");
//			out.print("<a href='editEventServlet?eventID="+eventID +"'>edit</a>  ");
//			out.println("<a href='deleteEventServlet?eventID="+eventID+"'>delete</a>");
			
			out.print("</div>\r\n"
					+ "</div>");
			i++;
		}while(rs.next());
		out.print("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
}

