package collagev1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class loginServlet  extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	{
		int regID=0;
		HttpSession sess=request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		regID=Integer.parseInt(request.getParameter("regID"));
		}catch(Exception e)
		{
			String errormsg=" Enter integer in Registration ID box only";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
			rd.forward(request,response);
		}
		String password=request.getParameter("password");
		
		if(loginDao.Logincheck(regID,password))
		{
			sess.setAttribute("hello", regID);
			//request.setAttribute("password",password);
//			out.print(password);
//			out.print(email);
//			out.print(sess.getAttribute(password));
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
			rd.forward(request,response);
		}
		else
		{
		String errormsg=regID +" Not found";	
		request.setAttribute("error",errormsg);
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
		rd.forward(request,response);
		
		}
		
	}
	
	
	
	
	

	
	public static void main(String args[]) {
		
		
		
	}
	
	
}
