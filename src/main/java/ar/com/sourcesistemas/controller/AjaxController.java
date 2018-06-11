package ar.com.sourcesistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.dao.ProductDAO;
import ar.com.sourcesistemas.hvq.factory.ModalFactory;
import ar.com.sourcesistemas.model.Product;

@Controller
public class AjaxController {

	@Autowired
	private ModalFactory modalFactory;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/user/getModal", method = RequestMethod.GET)
	public ModelAndView getModal(String modalName) {
		return modalFactory.getModal(modalName);
	}

	@RequestMapping(value = "/user/testeo", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void testeo() {

		List<Product> allProducts = productDAO.getAllProducts();
		allProducts.forEach(product -> System.out.println(product.getName()));

	}

}
