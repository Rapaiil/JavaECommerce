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
		<form action="loginModule" method="post">
			Username:<input type="text" name="username" required /><br/>
			Password:<input type="password" name="password" required /><br/>
			<input type="submit" value="LOGIN" /><br/><br/>
		</form>
		<form>
			<input type="submit" value="REGISTER" formaction="registerPage.jsp" formmethod="post" />
		</form>
		<hr/>
	</fieldset>
</body>
</html>