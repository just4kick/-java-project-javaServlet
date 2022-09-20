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
@WebServlet ("/updatePasswordServlet")
public class updatePasswordServlet extends HttpServlet {

	public void service(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException
	{
		HttpSession sess = request.getSession();
		if(sess.getAttribute("hello")==null)//need to improve later
		{
			//out.print(sess.getAttribute(password));
			String errormsg=" Need to Login First";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
			rd.forward(request,response);
		}
	
		
		
		
		try 
		{
			PrintWriter out=response.getWriter();
			String query="select password from studentdetail where registerID=?";
			String db= "student";
			Connection con=database.connect(db);
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,(int)sess.getAttribute("hello"));
			ResultSet rs=st.executeQuery();
			rs.next();
			
			if(rs.getString(1).equals(request.getParameter("currentPassword")))
			{
				
			
		if(request.getParameter("newpassword").equals(request.getParameter("renewpassword")))	
		{
		String updatepassword="update studentdetail set password=? where registerID=?";	
		PreparedStatement st1=con.prepareStatement(updatepassword);
		st1.setString(1,request.getParameter("newpassword"));
		st1.setInt(2,(int)sess.getAttribute("hello"));
		st1.executeUpdate();
		String errormsg="password updated";	
		request.setAttribute("error",errormsg);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
		rd.forward(request,response);	
		}
		else
		{
			String errormsg="password not match";	
			request.setAttribute("notMatch",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("updatePassword.jsp"); 	
			rd.forward(request,response);
		}
			}
			else
				
			{
				String errormsg="wrong password";	
				request.setAttribute("wrongPassword",errormsg);
				RequestDispatcher rd=request.getRequestDispatcher("updatePassword.jsp"); 	
				rd.forward(request,response);	
				
				
				
			}
			
			
			
			
			
		}catch(Exception e)
	{
		
		System.out.println(e);
		
	}
	
	
}
	}

