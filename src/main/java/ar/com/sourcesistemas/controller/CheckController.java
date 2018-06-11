package ar.com.sourcesistemas.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.dao.ProductDAO;
import ar.com.sourcesistemas.dto.CheckDTO;

@Controller
public class CheckController {

	private Map<String, CheckDTO> userCheck = new HashMap<String, CheckDTO>();
	private String[] payWith = { "Seleccione...", "debito", "credito", "efectivo" };
	@Autowired
	private ProductDAO productDAO;

	@PostMapping("/user/doCheck")
	@ResponseStatus(value = HttpStatus.OK)
	public void doCheck(@RequestBody CheckDTO checkDTO, Principal principal) {
		userCheck.put(principal.getName(), checkDTO);
	}

	@Transactional
	@GetMapping("/user/finishCheck")
	@ResponseBody
	public void finishCheck(Principal principal) {

		CheckDTO checkDTO = userCheck.get(principal.getName());

		// TODO complete this
	}

	@GetMapping("/user/getCheck")
	@ResponseBody
	public ModelAndView getCheck(Principal principal) {
		ModelAndView mav = new ModelAndView("user/finalCheckout");

		CheckDTO checkDTO = userCheck.get(principal.getName());
		mav.addObject("payWith", payWith);
		mav.addObject("checkDTO", checkDTO);
		mav.addObject("productsDTO", checkDTO.getProductsDTO());

		return mav;
	}

	@GetMapping("/user/getExpenses")
	@ResponseBody
	public CheckDTO getExpensesForUser(Principal principal) {
		return userCheck.get(principal.getName());
	}

	@GetMapping("/user/clearAll")
	@ResponseStatus(value = HttpStatus.OK)
	public void clearAll() {
		userCheck.clear();

	}

}
