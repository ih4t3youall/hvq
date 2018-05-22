package ar.com.sourcesistemas.hvq.factory;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ModalFactory {

	public final String MODAL_FOLDER = "modal";
	public final String SEPARATOR = "/";

	public ModelAndView getModal(String modalName) {

		ModelAndView mav = new ModelAndView(MODAL_FOLDER + SEPARATOR + modalName);
		return mav;
	}

}
