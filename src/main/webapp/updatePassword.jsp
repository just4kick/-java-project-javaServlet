<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updatePasswordServlet" method="post">

Enter current password<br>
<input type="password" name="currentPassword">${wrongPassword }<br>
Enter New password
<br>
<input type= "password" name="newpassword">
<br>
Confirm new password<br>
<input type = "password" name ="renewpassword"> 
<br>
<br>
${notMatch }
<input type= "submit" value="update Password">
</form>
</body>
</html>