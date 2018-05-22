package ar.com.sourcesistemas.hvq.factory;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ModalFactory {

	public final String MODAL_FOLDER = "modal";
	public final String SEPARATOR = "/";

	public ModelAndView getModal(String modalName) {

		ModelAndView mav = new ModelAndView(MODAL_FOLDER + SEPARATOR + modalName);
		String[] values = new String[6];
		values[0] = "martin";
		values[1] = "florencia";
		values[2] = "paradise";
		values[3] = "carla";
		values[4] = "juan";
		values[5] = "lequerica";

		for (String nose : values) {
			System.out.println(nose);
		}

		mav.addObject("countries", values);
		return mav;
	}

}
