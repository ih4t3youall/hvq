package ar.com.sourcesistemas.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sourcesistemas.model.Category;
import ar.com.sourcesistemas.model.Expense;
import ar.com.sourcesistemas.model.ExpenseForm;
import ar.com.sourcesistemas.model.User;
import ar.com.sourcesistemas.service.CategoryService;
import ar.com.sourcesistemas.service.ExpenseService;
import ar.com.sourcesistemas.service.UserService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;

	private final Logger LOGGER = LogManager.getLogger(ExpenseController.class);

	private double sumExpenses(List<Expense> expenses) {
		double sum = 0;
		for (Expense expense : expenses) {
			sum += expense.getPrice();
		}
		return sum;
	}

	@RequestMapping(value = "/expense", method = RequestMethod.GET)
	public ModelAndView expense() {
		ModelAndView modelAndView = new ModelAndView("/user/addExpense");
		ExpenseForm expenseForm = new ExpenseForm();
		List<Category> categories = categoryService.getAllCategories();
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("expenseForm", expenseForm);
		return modelAndView;
	}

	@RequestMapping(value = "/expense", method = RequestMethod.POST)
	public ModelAndView saveExpense(@Valid ExpenseForm expenseForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("/user/addExpense");
		List<Category> categories = categoryService.getAllCategories();
		modelAndView.addObject("categories", categories);
		if (!bindingResult.hasErrors()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			Category categoryObj = categoryService.findCategoryById(expenseForm.getCategory());
			Expense expense = new Expense();

			expense.setDate(expenseForm.getDate());
			expense.setDescription(expenseForm.getDescription());
			expense.setPrice(expenseForm.getPrice());
			expenseService.saveExpense(expense, categoryObj, user);
			modelAndView.addObject("successMessage", "El gasto ha sido cargado correctamente");
			modelAndView.addObject("expenseForm", new ExpenseForm());

		} else {
			modelAndView.addObject("failMessage",
					"El gasto no ha podido ser cargado chequee que todos los campos hayan sido completados");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/getExpenses", method = RequestMethod.GET)
	public ModelAndView getExpenses() {
		double total;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView modelAndView = new ModelAndView("/user/getExpenses");
		List<Expense> expenses = user.getExpenses();

		List<Category> categories = categoryService.getAllCategories();
		total = sumExpenses(expenses);
		modelAndView.addObject("expenses", expenses);
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("total", total);
		// LOGGER.warn(total);
		return modelAndView;
	}

	private List<Expense> filterByMonthAndCategory(List<Expense> expenses, String category, String month) {

		List<Expense> expensesFiltered = new ArrayList<Expense>();
		for (Expense expense : expenses) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(expense.getDate());
			int expenseMonth = cal.get(Calendar.MONTH);
			expenseMonth++;
			Integer.parseInt(month);
			if ((expense.getCategory().getId().equals(category)) && (expenseMonth == Integer.parseInt(month))) {
				expensesFiltered.add(expense);

			}
		}
		return expensesFiltered;

	}

	private List<Expense> filterByCategory(List<Expense> expenses, String category) {
		List<Expense> expensesFiltered = new ArrayList<Expense>();
		for (Expense expense : expenses) {
			if (expense.getCategory().getId().equals(category)) {
				expensesFiltered.add(expense);
			}
		}
		return expensesFiltered;
	}

	@RequestMapping(value = "/deleteExpense", method = RequestMethod.GET)
	public ModelAndView deleteExpense(@RequestParam long id) {
		expenseService.deleteExpense(id);
		return this.getExpenses();
	}

	@RequestMapping(value = "/expenseByCategory", method = RequestMethod.GET)
	public ModelAndView FilterExpenses(@RequestParam String category, @RequestParam String month) {
		double total;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView modelAndView = new ModelAndView("/user/getExpenses");
		List<Expense> expenses = user.getExpenses();
		List<Expense> expensesFiltered = new ArrayList<Expense>();
		if ((!category.isEmpty()) && (!month.isEmpty())) {
			expensesFiltered = this.filterByMonthAndCategory(expenses, category, month);
		} else {
			if (!category.isEmpty()) {
				expensesFiltered = this.filterByCategory(expenses, category);
			} else {
				if (!month.isEmpty()) {
					expensesFiltered = this.filterbyMonth(expenses, month);
				} else
					return this.getExpenses();
			}

		}

		List<Category> categories = categoryService.getAllCategories();
		total = sumExpenses(expensesFiltered);
		modelAndView.addObject("expenses", expensesFiltered);
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("total", total);
		if (expensesFiltered.isEmpty()) {
			modelAndView.addObject("emptyMessage", "No hay gastos para esa categoria y ese mes");
		}
		// LOGGER.warn(total);
		return modelAndView;
	}

	private List<Expense> filterbyMonth(List<Expense> expenses, String month) {
		List<Expense> expensesFiltered = new ArrayList<Expense>();
		for (Expense expense : expenses) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(expense.getDate());
			int expenseMonth = cal.get(Calendar.MONTH);
			expenseMonth++;
			Integer.parseInt(month);
			if ((expenseMonth == Integer.parseInt(month))) {
				expensesFiltered.add(expense);

			}
		}
		return expensesFiltered;
	}

}
