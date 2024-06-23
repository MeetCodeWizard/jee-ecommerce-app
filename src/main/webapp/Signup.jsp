<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="SignupServlet">
		FirstName : <input type="text" name="firstName" /> <br>
		<br> Email : <input type="text" name="email" /> <br>
		<br> Password : <input type="password" name="password" /> <br>
		<br> Gender : Male <input type="radio" value="Male" name="gender" />
		Female <input type="radio" value="Female" name="gender" /> <br>
		<br> <input type="submit" value="Signup" />
	</form>

</body>
</html>