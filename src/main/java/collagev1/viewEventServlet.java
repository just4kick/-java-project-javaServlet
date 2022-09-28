package collagev1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet ("/viewEventServlet")
public class viewEventServlet extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		
		HttpSession sess = request.getSession();
		//String ps=request.getParameter("password");
		//out.print(sess.getAttribute("hello"));
		if(sess.getAttribute("hello")==null)//need to improve later
		{
			//out.print(sess.getAttribute(password));
			String errormsg=" Need to Login First";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
			rd.forward(request,response);
		}
		
		PrintWriter out = response.getWriter();
		String query="select * from eventlist where serialNo=?;";
		Connection con =database.connect("student");
		int eventId=Integer.parseInt(request.getParameter("eventID"));
		PreparedStatement st;
		
		
		try {
			st = con.prepareStatement(query);
			st.setInt(1,eventId);
			ResultSet rs=st.executeQuery();
			rs.next();
//			if(sess.getAttribute("hello").equals(rs.getInt(1)))
//			{
			String name=rs.getString(2);
			String eventname=rs.getString(3);
			String college=rs.getString(4);
			String pname=rs.getString(5);
			String department=rs.getString(6);
			String eventdetail=rs.getString(7);
			String eventID=rs.getString(10);
			request.setAttribute("name",name);
			request.setAttribute("eventname",eventname);
			request.setAttribute("college",college);
			request.setAttribute("pname",pname);
			request.setAttribute("department",department);
			request.setAttribute("eventdetail",eventdetail);
			request.setAttribute("eventID",eventID);
			//out.print(name);
			request.setAttribute("registerID",rs.getInt(1));
			request.setAttribute("date",rs.getString(8));
			request.setAttribute("time",rs.getString(9));
			
			RequestDispatcher rd=request.getRequestDispatcher("viewCommentServlet"); 	
			rd.forward(request,response);
			
			
//			}else
//			{
//				
//				out.println("<a href='home.jsp'>home</a>   ");
//				out.println("event does not belong to you");
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	        }
	
	
	
	
	
}
