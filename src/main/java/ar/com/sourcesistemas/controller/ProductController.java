package ar.com.sourcesistemas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	private static final Map<String, Integer> prices = new HashMap<String, Integer>();

	public ProductController() {
		init();
	}

	@RequestMapping(value = "/user/getProductPriceByName", method = RequestMethod.GET)
	public @ResponseBody String getProructPriceByName(String productName) {
		return prices.get(productName).toString();

	}

	public void init() {

		String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };

		for (int i = 0; i < values.length; i++) {
			prices.put(values[i], i);
		}
	}
}
