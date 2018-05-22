package ar.com.sourcesistemas.hvq.factory;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ModalFactory {

	public final String MODAL_FOLDER = "modal";
	public final String SEPARATOR = "/";
	public String[] values = { "martin", "florencia", "paradise", "carla", "juan", "lequerica" };

	public ModelAndView getModal(String modalName) {

		ModelAndView mav = new ModelAndView(MODAL_FOLDER + SEPARATOR + modalName);
		populate(modalName, mav);
		return mav;
	}

	public void populate(String modalName, ModelAndView mav) {

		switch (modalName) {
		case "expenseModal":
			mav.addObject("countries", values);

			break;
		}

	}

}
