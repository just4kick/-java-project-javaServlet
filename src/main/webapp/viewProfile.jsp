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
HttpSession sess=request.getSession(false);
if(sess.getAttribute("hello")==null)//need to improve later
{
	//out.print(sess.getAttribute(password));
	String errormsg=" Need to Login First";	
	request.setAttribute("error",errormsg);
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 	
	rd.forward(request,response);
}
if(request.getAttribute("registerID")==null)
{
	//String errormsg=" select event first";	
	//request.setAttribute("error",errormsg);
	//RequestDispatcher rd=request.getRequestDispatcher("editProfileServlet"); 	
	//rd.forward(request,response);
	response.sendRedirect("viewProfileServlet");
}



%>
<form action="updateProfileServlet" method="post">
Enter Registration number
<input type ="text" value="${registerID }" name="rgnumber" readonly>Only be edited by admin
<br><br>
Enter college name

<input type ="text" value="${college }" name="college">
<br><br>
Enter your name

<input type ="text" value="${name }" name="name">
<br><br>
Enter email
<input type ="email" value="${email }" name="email">
<br><br>

Enter department
<input type ="text" value="${department }" name="department">
<br><br>

<input type="submit" value ="update Profile">




</form>
<br><br>
change password click  <a href ="updatePassword.jsp" >here</a>




</body>
</html>