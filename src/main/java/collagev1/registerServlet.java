package collagev1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class registerServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException
	        {
		response.setContentType("text/html");
		int registerID=Integer.parseInt(request.getParameter("rgnumber"));
		String name=request.getParameter("name");;
		String college=request.getParameter("college");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String rpassword=request.getParameter("repass");
		String department = request.getParameter("department");
		if(password.equals(rpassword))
		{
			if(registerDao.ercheck(registerID,email))
			{
				if(registerDao.registerDetail(registerID,name,college,email,password,department))
				{
					
				HttpSession sess=request.getSession();
				sess.setAttribute("hello",registerID );
				sess.setAttribute("helloname",name );
				response.sendRedirect("home.jsp");
				}
				else
				{
					String errormsg="Your data might not store Contact admin";	
					request.setAttribute("error",errormsg);
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
					rd.forward(request,response);	
				}
			
			}else
			{
			String errormsg="Email or Registration Id is alreay used";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
			rd.forward(request,response);
				
			}
		}else
		{
			String errormsg="Enter same password in both password box";	
			request.setAttribute("error",errormsg);
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp"); 	
			rd.forward(request,response);
		}
		
		
		
	        }
	
	
	
	
}
