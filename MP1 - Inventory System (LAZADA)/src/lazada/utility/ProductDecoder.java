package lazada.utility;

import java.util.*;
import lazada.model.*;

public class ProductDecoder {

	public static void main(String[] args) {
		ArrayList<ProductBean> products;
		XmlFileController controller = new XmlFileController();
		
		try {
			controller.readProductDb();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
