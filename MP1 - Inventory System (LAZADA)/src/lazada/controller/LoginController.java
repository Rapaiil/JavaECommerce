package lazada.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lazada.model.*;

@WebServlet("/loginauth")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean(request.getParameter("username").trim(), request.getParameter("password"));
		ArrayList<ProductBean> productList = user.retrieveProductList();
		
		if(productList != null) {
			request.setAttribute("products", productList);
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}	
	}

}
