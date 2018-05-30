package ar.com.sourcesistemas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.sourcesistemas.model.Product;

@Controller
public class ProductController {

	private Map<String, Integer> prices = new HashMap<String, Integer>();

	@GetMapping("/user/getProductPriceByName")
	@ResponseBody 
	public String getProructPriceByName(String productName) {
		init();
		return prices.get(productName).toString();
	}

	@PostMapping(value = "/user/getProductById")
	@ResponseBody 
	public Product getPoruductById2(@RequestBody String id) {
		System.out.println("id: " + id);
		Product product = new Product();
		product.setName("productName");
		product.setPrice(10);

		return product;
	}
	
	@GetMapping(value = "/user/getProductById")
	@ResponseBody 
	public Product getPoruductById(String id) {
		System.out.println("id: " + id);
		Product product = new Product();
		product.setName("productName");
		product.setPrice(10);

		return product;
	}


	public void init() {
		String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };
		for (int i = 0; i < values.length; i++) {
			prices.put(values[i], i);
		}
	}
}

