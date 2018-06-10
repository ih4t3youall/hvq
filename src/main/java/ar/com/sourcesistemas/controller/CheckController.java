package ar.com.sourcesistemas.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.dto.CheckDTO;

@Controller
public class CheckController {

	private Map<String, CheckDTO> userCheck = new HashMap<String, CheckDTO>();
	private String[] payWith = { "Seleccione...", "debito", "credito", "efectivo" };

	@PostMapping("/user/doCheck")
	@ResponseBody
	public String doCheck(@RequestBody CheckDTO checkDTO, Principal principal) {
		userCheck.put(principal.getName(), checkDTO);
		return "200ok";
	}

	@GetMapping("/user/getCheck")
	@ResponseBody
	public ModelAndView getCheck(Principal principal) {
		ModelAndView mav = new ModelAndView("user/test");

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
