package collagev1;

import java.io.IOException;
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
@WebServlet("/alterEventServlet")
public class alterEventServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		
		String name=request.getParameter("name");
		String eventname=request.getParameter("eventname");
		String college=request.getParameter("college");
		String pname=request.getParameter("pname");
		String department=request.getParameter("department");
		String eventdetail=request.getParameter("eventdetail");
		String eventID=request.getParameter("eventID");
		try {
		String query="update eventlist set name=?,eventname=?,college=?,pname=?,department=?,eventdetail=? where serialNo=?;";	
		String db="student";
		Connection con=database.connect(db);
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2,eventname);
		st.setString(3,college);
		st.setString(4,pname);
		st.setString(5,department);
		st.setString(6,eventdetail);
		st.setString(7,eventID);
		st.executeUpdate();
		String msg="Your post is updated";	
		request.setAttribute("error",msg);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
		rd.forward(request,response);
		} catch (SQLException e) {
			
			String msg="Facing Issue for reposting";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
		}
	
	
	
}
}