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

if(request.getAttribute("eventname")==null)
{
	String errormsg=" select event first";	
	request.setAttribute("error",errormsg);
	RequestDispatcher rd=request.getRequestDispatcher("myEventServlet"); 	
	rd.forward(request,response);
}
%>
<h3>Editing Event name  <u>${eventname }</u>  and Event ID   ${eventID }</h3><br>
<form action="alterEventServlet" method="post">
Enter your name<br>
<input type="text" value="${name }" name="name">
<br>
Enter Event name<br>
<input type="text" value="${eventname}" name="eventname">
<br>
Enter your college name<br>
<input type="text" value="${college }" name="college"><br>
Enter Person Head name<br>
<input type="text" value="${pname }" name="pname"><br>
Enter Department<br/>
 <input type="text" value="${department }" name="department"/><br/>
  Describe your event<br/>
  <textarea  name="eventdetail" rows="10" cols="50">${eventdetail }</textarea><br/><br/>
  <input type="hidden" value ="${eventID }" name="eventID">
  <input type="submit" value="RePost"/>        <a href = "myEventServlet">cencel</a>
  
</form>

</body>
</html>