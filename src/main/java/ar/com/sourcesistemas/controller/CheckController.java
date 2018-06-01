package ar.com.sourcesistemas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.sourcesistemas.dto.CheckDTO;

@Controller
public class CheckController {

	@PostMapping("/user/doCheck")
	@ResponseBody
	public String doCheck(@RequestBody CheckDTO checkDTO) {
		System.out.println(checkDTO.toString());
		return null;
	}

}
