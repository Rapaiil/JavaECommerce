package lazada.model;

/**
 * 
 *Product contains:
> Product Name
> Product Description
> Product Id
> Product Price
> Product Stock
> Product Image

Home:
> Display all products
> Display count in cart

Cart:
> Display all products in tabulated form
> Display total price
> Display VAT
 *
 */
public class ProductBean {
	private String product_id;
	private String product_name;
	private String product_description;
	private int product_stock;
	private String product_image;
	private float product_price;
	
	public ProductBean() {
		//empty constructor
	}
	
	public ProductBean(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	
	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	private void process() {
		
	}
	
	private void addToCart() {
		
	}
}
