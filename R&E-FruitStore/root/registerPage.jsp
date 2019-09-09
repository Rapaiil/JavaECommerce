<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>R&amp;E's FruitStore</title>
</head>
<body>
	<h1>Login and Register Demo</h1>
	<fieldset>
		<legend>Register</legend>
		<form action="emailvalidation.action" method="POST">
			<h3>Basic Information</h3>
			First Name:<input type="text" name="user_firstname" required/><br/>
			Last Name:<input type="text" name="user_lastname" required/><br/>
			Email Address:<input type="text" name="user_email" required/>
			<% if(request.getParameter("errduplicate") != null) { %>
				<i><font color='red'> Email address exists! Please use another email address.</font></i>
			<% } %>
			<br/>
			Phone Number:<input type="text" name="user_phonenumber" placeholder="Optional" /><br/>
			<input type="submit" value="Next" />
		</form>
	</fieldset>
</body>
</html>