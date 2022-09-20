package collagev1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/addEventServlet")
public class addEventServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		HttpSession sess=request.getSession(false);
		int registerID=(int) sess.getAttribute("hello");
		String name=request.getParameter("name");
		String eventname=request.getParameter("eventname");
		String college=request.getParameter("college");
		String pname=request.getParameter("pname");
		String department=request.getParameter("department");
		String eventdetail=request.getParameter("eventdetail");
		if(addEventDao.addEvent(registerID,name, eventname,college,pname,department,eventdetail))
		{
			String msg="Your post is uploaded";	
			request.setAttribute("error",msg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
		}
		else
		{
			String errormsg="Your data might not store Contact admin";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
		}
		
		
	        }

}
