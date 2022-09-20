package collagev1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteEventServlet")
public class deleteEventServlet extends HttpServlet {

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

		String query="delete from eventlist where serialNo=?;";
		Connection con =database.connect("student");
		int eventId=Integer.parseInt(request.getParameter("eventID"));
		PreparedStatement st;
		PreparedStatement st1;
		try
		
		{	String check= "select registerID from eventlist where serialNo=?";
		st1 = con.prepareStatement(check);
		st1.setInt(1, eventId);	
		ResultSet rs1=st1.executeQuery();
		rs1.next();
		int registerIDdb=rs1.getInt(1);
		int registerID=(int) sess.getAttribute("hello");
		if(registerIDdb==registerID) {
			st = con.prepareStatement(query);
			st.setInt(1, eventId);
			st.executeUpdate();
			String msg="Your post is Deleted";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("myEventServlet"); 	
			rd.include(request,response);
		}
		else
		{
			String msg="you have not funking right to delete this event UNDERSTAND?";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);	
		}
		}catch(Exception e)
		{
			String msg="Facing problem while deleting";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
		}
	
	
}
}
