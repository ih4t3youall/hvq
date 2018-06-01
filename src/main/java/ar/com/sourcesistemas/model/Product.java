package ar.com.sourcesistemas.model;

public class Product {

	private String name;
	private double price;
	private ProductCategory productCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("name: ").append(name).append("price: ").append(price)
				.append("Product Category: ").append(productCategory.toString()).toString();

	}

}
