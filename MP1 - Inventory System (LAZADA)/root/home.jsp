<%@ page import="java.util.*" %>
<%@ page import="lazada.model.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <jsp:useBean id="product" type="lazada.model.ProductBean" scope="application" /> --%>
<jsp:useBean id="user" type="lazada.model.UserBean" scope="session" />
<!DOCTYPE html>
<% ArrayList<ProductBean> productList = new ArrayList<ProductBean>(); %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>R&amp;E Fruit Shop</title>
	<link rel="stylesheet" type="text/css" href="css/modal-style.css" >
</head>
<body>
	<% productList = (ArrayList<ProductBean>) request.getAttribute("products"); %>
	<h2>Welcome, ${user.username}</h2>
	</hr>
	<h5>Our Produce</h5>
	<% for(ProductBean product: productList) { %>
		<div>
		ID: <b><%= product.getProduct_id() %></b>
		<div id="modal-btn">
			<img src="<%= product.getProduct_image() %>" width="50px" height="50px" /></br>
			Name: <%= product.getProduct_name() %></br>
			Desc: <%= product.getProduct_description() %></br>
			Price: Php<%= product.getProduct_price() %></br>
			Stock left: <%= product.getProduct_stock() %>
		</div>
		</br></br>
		</div>
	<% } %>
	
	<div class="modal">
	  <div class="modal-header">
	    <span class="close-btn">&times;</span>
	    <h1>Add to Cart</h1>
	  </div>
	  <div class="modal-content">
	    <p>this is the text inside the modal</p>
	  </div>
	</div>
</body>

	<script type="text/javascript">
		let modalBtn = document.getElementById("modal-btn")
		let modal = document.querySelector(".modal")
		let closeBtn = document.querySelector(".close-btn")
		modalBtn.onclick = function(){
		  modal.style.display = "block"
		}
		closeBtn.onclick = function(){
		  modal.style.display = "none"
		}
		window.onclick = function(e){
		  if(e.target == modal){
		    modal.style.display = "none"
		  }
		}
	</script>
</html>