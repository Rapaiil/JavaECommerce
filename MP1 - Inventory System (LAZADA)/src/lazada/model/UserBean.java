package lazada.model;

import java.util.ArrayList;

import lazada.utility.XmlFileController;

public class UserBean implements LazadaOnlineOrdering {
	private String username;
	private String password;
	
	public UserBean() {}
	
	public UserBean(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void validateCreditCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computeGrossPay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computeVAT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generatePDFReceipt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void netPay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPDFSalesReport() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<ProductBean> retrieveProductList() {
		ArrayList<ProductBean> productList = null;
		XmlFileController controller = new XmlFileController();
		
		try {
			productList = controller.readProductDb();	
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return productList;
	}
}
