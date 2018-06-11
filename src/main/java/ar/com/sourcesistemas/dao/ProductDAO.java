package ar.com.sourcesistemas.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.com.sourcesistemas.model.Product;
import ar.com.sourcesistemas.model.ProductCategory;

@Service
public class ProductDAO {
	private Map<String, Integer> prices = new HashMap<String, Integer>();
	private Map<String, Product> products = new HashMap<String, Product>();

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void init() {
		String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };
		for (int i = 0; i < values.length; i++) {
			prices.put(values[i], i);
			Product product = new Product(values[i], i, ProductCategory.OTHERS);
			products.put(values[i], product);
			entityManager.persist(product);
		}
	}

	@Transactional
	public Product getProructPriceByName(String productName) {
		Product product = new Product();
		product.setName(productName);
		product.setPrice(prices.get(productName));
		product.setProductCategory(ProductCategory.VETERINARIAN.toString());
		return product;

	}

	@Transactional
	public Product getProductByName(String productName) {

		return products.get(productName);

	}

	@Transactional
	public Product getPoruductById(int id) {
		return new Product("productName", 10, ProductCategory.OTHERS);

	}

}
