package ar.com.sourcesistemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.hvq.factory.ModalFactory;

@Controller
public class AjaxController {

	@Autowired
	private ModalFactory modalFactory;

	@RequestMapping(value = "/user/getModal", method = RequestMethod.GET)
	public ModelAndView getModal(String modalName) {
		return modalFactory.getModal(modalName);

	}

}
