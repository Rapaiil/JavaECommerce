package lazada.utility;

import java.io.IOException;
import java.util.ArrayList;

import lazada.model.*;

public class ProductEncoder {

	public static void main(String[] args) {
		ProductBean product;
		XmlFileController controller = new XmlFileController();
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();
		String product_Id_format;
		int ctr = 1;
		boolean isContinued;
		
		try {
			do {
				product = new ProductBean();
				isContinued = false;
				
				System.out.println("Product #" + ctr);
				product_Id_format = "PROD" + String.format("%03d", ctr);
				System.out.println("ID: " + product_Id_format);
				product.setProduct_id(product_Id_format);
				System.out.print("Product name: ");
				product.setProduct_name(Reader.readString(""));
				System.out.print("Product description: ");
				product.setProduct_description(Reader.readString(""));
				System.out.print("Product price: ");
				product.setProduct_price((float)Reader.readDouble(""));
				System.out.print("Product stock left: ");
				product.setProduct_stock(Reader.readInt(""));
				product.setProduct_image("images/" + product.getProduct_name() + ".jpg");
				
				productList.add(product);
				char choice = Reader.readChar("\nWould you like to add another product [Y/N]?\n>> ");
				
				if(choice == 'Y' || choice == 'y') {
					isContinued = !isContinued;
					ctr++;
				}
			} while(isContinued);
			
			controller.updateProductDb(productList);
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
