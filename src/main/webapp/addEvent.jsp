<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<form action="addEventServlet" method="post">
<h2>Register your event </h2>
Enter your name<br>
<input type="text" name="name">
<br>
Enter Event name<br>
<input type="text" name="eventname">
<br>
Enter your college name<br>
<input type="text" name="college"><br>
Enter Person Head name<br>
<input type="text" name="pname"><br>
Enter Department<br/>
 <input type="text" name="department"/><br/>
  Describe your event<br/>
  <textarea name="eventdetail" rows="10" cols="50"></textarea><br/><br/>
  <input type="submit" value="Post"/>
  
</form>
<br>
<a href="home.jsp">Back home</a>


</body>
</html>