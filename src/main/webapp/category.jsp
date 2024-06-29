<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CategoryServlet" method="post">
		Category Id : <input type="text" name="categoryId" /> <br>
		<br> Category Name : <input type="text" name="categoryName" /> <br>
		<br> Description : <textarea rows="1" cols="20" name="description"></textarea> <br>
		<br> <input type="submit" value="Submit" />
	</form>
</body>
</html>