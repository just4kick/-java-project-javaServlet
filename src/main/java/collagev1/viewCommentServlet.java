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
@WebServlet ("/viewCommentServlet")
public class viewCommentServlet extends HttpServlet {
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
		PrintWriter out=response.getWriter();
	
		RequestDispatcher rd=request.getRequestDispatcher("viewEvent.jsp"); 	
		rd.include(request,response);
		out.print("<p>hello</p>");
		try
		{	int postID=Integer.parseInt(request.getParameter("eventID"));
			
			String query="select * from comment where postID=?";
			String db="student";
			Connection con =database.connect(db);
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,postID);
			ResultSet rs=st.executeQuery();
			if(!rs.next())
			{
				out.print("not comment yet");
			}
			
			do {
//				out.print(rs.getInt(1));
//				out.println(rs.getInt(2));
				out.println(rs.getInt(3));
				out.println("<br>");
				out.println(rs.getString(4));
//				out.println(rs.getString(5));
//				out.println(rs.getString(6));
				out.println("<br>");
				
				
			}while(rs.next());
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	        }
}
