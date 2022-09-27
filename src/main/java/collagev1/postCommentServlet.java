package collagev1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/postCommentServlet")
public class postCommentServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		try {
			
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
			PrintWriter out= response.getWriter();
			//out.print("heli");
			
			String db = "student";
			Connection con =database.connect(db);
			String query = "insert into comment value(0,?,?,?,current_date(),current_time());";
			String comment = request.getParameter("comment");
			
			out.print(comment);
			out.print(request.getParameter("eventID"));
			
			if(request.getParameter("eventID")==null)
			{
			
				
				RequestDispatcher rd=request.getRequestDispatcher("viewEvent.jsp"); 	
				rd.forward(request,response);		
			}
			if(!comment.equals(""))
			{
			int eventID=Integer.parseInt(request.getParameter("eventID"));
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,Integer.parseInt(request.getParameter("eventID")));
			st.setInt(2, (int) sess.getAttribute("hello"));
			st.setString(3,comment);
			st.executeUpdate();
			String msg="Commented";	
			request.setAttribute("msg",msg);
			RequestDispatcher rd=request.getRequestDispatcher("viewEventServlet?eventID="+eventID); 	
			rd.forward(request,response);
			}
			else
			{
				int eventID=Integer.parseInt(request.getParameter("eventID"));
				String errormsg="Comment Box emty";	
				request.setAttribute("error",errormsg);
				RequestDispatcher rd=request.getRequestDispatcher("viewEventServlet?eventID="+eventID); 	
				rd.forward(request,response);	
			}
			
			
			
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	        }
	
	
}
