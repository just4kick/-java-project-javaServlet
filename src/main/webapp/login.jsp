<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%

HttpSession sess = request.getSession();
//String ps=request.getParameter("password");
//out.print(sess.getAttribute("hello"));
if(sess.getAttribute("hello")!=null)//need to improve later
{
	//out.print(sess.getAttribute(password));
	String errormsg=" Your already logged";	
	request.setAttribute("error",errormsg);
	RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 	
	rd.forward(request,response);
}


%>

<form action="login" method="POST" >
<br><br>
${error}
<br><br>
Enter your registerID

<input type="text" name ="regID">
<br><br>
Enter your password
<input type ="password" name ="password">
<br><br>
<input type ="submit" value ="Login">





</form>
<a href="register.jsp">register</a>


</body>
</html>