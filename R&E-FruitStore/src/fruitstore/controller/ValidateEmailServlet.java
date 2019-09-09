package fruitstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruitstore.model.User;

@WebServlet("/emailvalidation.action")
public class ValidateEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("user_firstname").trim(),
				lastname = request.getParameter("user_lastname").trim(),
				email = request.getParameter("user_email").trim(),
				phonenumber = request.getParameter("user_phonenumber").trim();
		User temp_user;
		
		if(!new User().checkDuplicateEmail(email)) {
			temp_user = new User(firstname, lastname, email, phonenumber);
			request.setAttribute("temp_user", temp_user);
			response.sendRedirect("loginCred.jsp");
		} else {
			response.sendRedirect("registerPage.jsp?errduplicate=1");
		}
	}

}
