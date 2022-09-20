<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method ="post">
Enter college name

<input type ="text" name="college">
<br><br>
Enter your name

<input type ="text" name="name">
<br><br>
Enter email
<input type ="email" name="email">
<br><br>
Enter Registration number
<input type ="text" name="rgnumber">
<br><br>
Enter department
<input type ="text" name="department">
<br><br>
${error }
<br><br>
Enter password
<input type ="password" name="pass">
<br><br>
Enter password again
<input type ="password" name="repass">
<br><br>
<br><br>
<input type="submit" value ="register">




</form>
<br>
Already have account? <a href="login.jsp">Login</a>



</body>
</html>