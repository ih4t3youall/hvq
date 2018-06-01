package ar.com.sourcesistemas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.sourcesistemas.dao.ProductDAO;
import ar.com.sourcesistemas.model.Product;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductDAO productDAO;

	@GetMapping("/user/getProductPriceByName")
	@ResponseBody
	public Product getProructPriceByName(String productName) {

		return productDAO.getProructPriceByName(productName);
	}

	@GetMapping(value = "/user/getProductById")
	@ResponseBody
	public Product getPoruductById(int id) {

		return productDAO.getPoruductById(id);
	}

}
