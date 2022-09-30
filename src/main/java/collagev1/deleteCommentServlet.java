package collagev1;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

//@WebServlet ("/deleteCommentServlet")
public class deleteCommentServlet{
	

	public static boolean delAllcomment(int eventID)
	{	
		boolean status =false;
		PreparedStatement st;
		PreparedStatement st1;
		ResultSet rs;
		try
		{
			Connection con =database.connect("student");
			
			String query="select * from comment where postID = ?";
			st1 = con.prepareStatement(query);
			st1.setInt(1, eventID);
			rs=st1.executeQuery();
			
			
			if (!rs.next()) 
			{
				status=false;
			}else {
				
				
		String delcomment="delete from comment where postID=?;";
		st = con.prepareStatement(delcomment);
		st.setInt(1,eventID);
		st.executeUpdate();
		status =true;
		
			
			}
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void service(HttpServletRequest request, HttpServletResponse response)  
//	        throws ServletException, IOException
//	        {
//		
//		HttpSession sess = request.getSession();
//		//String ps=request.getParameter("password");
//		//out.print(sess.getAttribute("hello"));
//		if(sess.getAttribute("hello")==null)//need to improve later
//		{
//			//out.print(sess.getAttribute(password));
//			String errormsg=" Need to Login First";	
//			request.setAttribute("error",errormsg);
//			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
//			rd.forward(request,response);
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	        }
	

}
