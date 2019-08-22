package lazada.controller;

import java.util.ArrayList;
import lazada.model.*;

public class TestUser {

	public static void main(String[] args) {
		UserBean user = new UserBean();
		ArrayList<ProductBean> productList = user.retrieveProductList();
		for(ProductBean product: productList) {
			System.out.println(product.getProduct_id());
			System.out.println(product.getProduct_name());
			System.out.println(product.getProduct_description());
			System.out.println(product.getProduct_price());
			System.out.println(product.getProduct_stock());
		}
	}

}
