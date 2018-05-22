package ar.com.sourcesistemas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.model.User;
import ar.com.sourcesistemas.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			return new ModelAndView("registration");
		} else {
			userService.saveUser(user);
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value = "/user/test", method = RequestMethod.GET)
	public ModelAndView test() {
		return new ModelAndView("user/test");

	}

	@RequestMapping(value = "/user/getModal", method = RequestMethod.GET)
	public ModelAndView getModal() {
		return new ModelAndView("modal/ExpenseModal");
	}

	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("user/home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		// modelAndView.addObject("userName", "Welcome " + user.getName() + " " +
		// user.getLastName() + " (" + user.getEmail() + ")");
		// modelAndView.addObject("adminMessage","Content Available Only for Users with
		// Admin Role");
		modelAndView.addObject("currentUser", user);
		// modelAndView.setViewName("user/home");
		return modelAndView;
	}

}