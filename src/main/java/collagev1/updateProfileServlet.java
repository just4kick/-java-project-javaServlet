package collagev1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/updateProfileServlet")
public class updateProfileServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		try 
		{
			HttpSession sess=request.getSession(false);
			String query = "update studentdetail set name=?,college=?,email=?,department=? where registerID=?";
			String db="student";
			Connection con=database.connect(db);
			int registerID=(int) sess.getAttribute("hello");
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,request.getParameter("name"));
			st.setString(2,request.getParameter("college"));
			st.setString(3,request.getParameter("email"));
			st.setString(4,request.getParameter("department"));
			st.setInt(5,registerID);
			st.executeUpdate();
			String msg="Your profile is updated";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
			
			
			
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);	}
		
		
		
		
		
	        }

}
