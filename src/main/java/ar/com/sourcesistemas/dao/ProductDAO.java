package ar.com.sourcesistemas.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import ar.com.sourcesistemas.model.Product;
import ar.com.sourcesistemas.model.ProductCategory;

@Service
public class ProductDAO {
	private Map<String, Integer> prices = new HashMap<String, Integer>();

	public ProductDAO() {
		init();

	}

	public void init() {
		String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };
		for (int i = 0; i < values.length; i++) {
			prices.put(values[i], i);
		}
	}

	public Product getProructPriceByName(String productName) {
		Product product = new Product();
		product.setName(productName);
		product.setPrice(prices.get(productName));
		product.setProductCategory(ProductCategory.VETERINARIAN);
		return product;

	}

	public Product getPoruductById(int id) {
		Product product = new Product();
		product.setName("productName");
		product.setPrice(10);
		product.setProductCategory(ProductCategory.OTHERS);
		return product;

	}

}
