package lazada.utility;

import java.beans.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import lazada.model.ProductBean;

public class XmlFileController {
	final String path = "C:\\Users\\Y50-70\\Documents\\Rapaiil\\iAcademy\\Term 4\\ENTJAV2\\reports\\db\\";
	final String xmlFile = "productDB.xml";
	
	public XmlFileController() {
		//empty constructor
	}
	
	public void updateProductDb(ArrayList<ProductBean> productList) throws Exception {
		XMLEncoder xmle = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path + xmlFile)));
		final String givenDate = "Updated as of " + new SimpleDateFormat("hh:mm:ss a MMMM d, yyyy").format(new Date());
		
		xmle.writeObject(givenDate);
		for(ProductBean product: productList) {
			xmle.writeObject(product.getProduct_id());
			xmle.writeObject(product.getProduct_name());
			xmle.writeObject(product.getProduct_description());
			xmle.writeObject(product.getProduct_price());
			xmle.writeObject(product.getProduct_stock());
			xmle.writeObject(product.getProduct_image());
		}
		xmle.close();
	}
	
	public ArrayList<ProductBean> readProductDb() throws Exception {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();
		ProductBean product;
		XMLDecoder xmld = new XMLDecoder(new BufferedInputStream(new FileInputStream(path + xmlFile)));
		String date = (String) xmld.readObject();
		
		for(int i=12; i > 0; i--) {
			product = new ProductBean((String) xmld.readObject());
			product.setProduct_name((String) xmld.readObject());
			product.setProduct_description((String) xmld.readObject());
			product.setProduct_price((float) xmld.readObject());
			product.setProduct_stock((int) xmld.readObject());
			product.setProduct_image((String) xmld.readObject());
			
			System.out.println(product.getProduct_id());
			System.out.println(product.getProduct_name());
			System.out.println(product.getProduct_description());
			System.out.println(product.getProduct_price());
			System.out.println(product.getProduct_stock());
			System.out.println(product.getProduct_image());
			
			productList.add(product);
		}
		
		xmld.close();
		return productList;
	}
}
