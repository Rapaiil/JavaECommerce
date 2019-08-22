<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>R&amp;E Fruit Shop</title>
</head>
<body>
<fieldset>
	<legend>Welcome to R&amp;E Fruitas Shop!</legend>
	<form action="loginauth" method="POST">
		<input type="text" name="username" size="50" required />
		<input type="password" name="password" required />
		<input type="submit" value="Login" />
	</form>
</fieldset>
</body>
</html>