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
HttpSession sess = request.getSession(false);
if(sess.getAttribute("hello").equals(request.getAttribute("registerID")))
{
out.print("<a href='myEventServlet'>Back My Event</a><br><br>");
out.print("<a href='allEventServlet'>all Event</a><br><br>");
}
else {

	out.print("<a href='allEventServlet'>all Event</a><br><br>");
}



%>



${name }
<br>
${eventname }
<br>
${college }
<br>
${pname }
<br>
${department }
<br>
${eventdetail }
<br>
${eventID }
<br>
${registerID }
<br>
${date }
<br>
${time }
<br>
${msg }
<form action="postCommentServlet">
<input type= "hidden" value ="${eventID }" name ="eventID" >
${error }
<textarea name="comment" placeholder="Comment here" rows="2" cols="50"></textarea>
<input type = "submit" value="Comment">
</form>
<% 

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

</body>
</html>