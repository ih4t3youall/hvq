package ar.com.sourcesistemas.service;

import ar.com.sourcesistemas.model.Category;
import ar.com.sourcesistemas.model.Expense;
import ar.com.sourcesistemas.model.User;

public interface ExpenseService {
	public void saveExpense(Expense expense, Category category, User user);

	public void deleteExpense(long id);
}
