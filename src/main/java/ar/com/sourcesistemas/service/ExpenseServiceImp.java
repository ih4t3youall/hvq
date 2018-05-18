package ar.com.sourcesistemas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sourcesistemas.model.Category;
import ar.com.sourcesistemas.model.Expense;
import ar.com.sourcesistemas.model.User;
import ar.com.sourcesistemas.repository.ExpenseRepository;

@Service
@Transactional
public class ExpenseServiceImp implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void saveExpense(Expense expense, Category category, User user) {

		expense.setUser(user);
		expense.setCategory(category);
		expenseRepository.save(expense);

	}

	@Override
	public void deleteExpense(long id) {
		expenseRepository.deleteById(id);
	}
}
