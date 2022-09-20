<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${error }
</br></br>
<a href="logout">logout</a>
</br></br>


<%

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


%>
this is Git change
</br></br>
<a href="myEventServlet">view my event</a>
</br></br>
</br></br>
<a href="viewProfileServlet">edit Profile</a>
</br></br>
</br></br>
<a href="allEventServlet">view all event</a>
</br></br>
<a href="addEvent.jsp">Add your event</a><br><br><br>
welcome to home<br><br>
under development
</body>
</html>