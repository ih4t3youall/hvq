package ar.com.sourcesistemas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.sourcesistemas.dto.ProductDTO;
import ar.com.sourcesistemas.model.Product;
import ar.com.sourcesistemas.model.ProductCategory;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	private Map<String, Integer> prices = new HashMap<String, Integer>();

	@GetMapping("/user/getProductPriceByName")
	@ResponseBody
	public String getProructPriceByName(String productName) {
		init();
		return prices.get(productName).toString();
	}

	@GetMapping(value = "/user/getProductById")
	@ResponseBody
	public Product getPoruductById(String id) {
		System.out.println("id: " + id);
		logger.debug("logeado por debug id= " + id);
		Product product = new Product();
		product.setName("productName");
		product.setPrice(10);
		product.setProductCategory(ProductCategory.VETERINARIAN);

		return product;
	}

	@PostMapping(value = "/user/doCheck")
	@ResponseBody
	public Product doCheck(@RequestBody List<ProductDTO> productDTO) {


		Product product = new Product();
		product.setName("productName");
		product.setPrice(10);
		product.setProductCategory(ProductCategory.VETERINARIAN);

		return product;
	}

	public void init() {
		String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };
		for (int i = 0; i < values.length; i++) {
			prices.put(values[i], i);
		}
	}
}
