package collagev1;

import java.io.IOException;
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

import com.mysql.cj.Session;

@WebServlet ("/viewProfileServlet")
public class viewProfileServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		HttpSession sess=request.getSession(false);
		if(sess.getAttribute("hello")==null)//need to improve later
		{
			//out.print(sess.getAttribute(password));
			String errormsg=" Need to Login First";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
			rd.forward(request,response);
		}
		String query="Select * from studentdetail where registerID=?";
		try
		{
			String db="student";
			Connection con=database.connect(db);
			PreparedStatement st=con.prepareStatement(query);
			int registerID=(int)sess.getAttribute("hello");
			st.setInt(1,registerID);
			ResultSet rs=st.executeQuery();
			rs.next();
			request.setAttribute("registerID",rs.getInt(1));
			request.setAttribute("name",rs.getString(2));
			request.setAttribute("college",rs.getString(3));
			request.setAttribute("email",rs.getString(4));
			request.setAttribute("department",rs.getString(6));
			RequestDispatcher rd=request.getRequestDispatcher("viewProfile.jsp"); 	
			rd.forward(request,response);
			
			
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		
	        }

}
