package ar.com.sourcesistemas.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.dto.CheckDTO;

@Controller
public class CheckController {

	private Map<String, CheckDTO> userCheck = new HashMap<String, CheckDTO>();
	private String[] payWith = { "debito", "credito", "cash" };

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

		return mav;
	}

	@GetMapping("/user/clearAll")
	public String clearAll() {
		userCheck.clear();

		return "200ok";
	}

}
