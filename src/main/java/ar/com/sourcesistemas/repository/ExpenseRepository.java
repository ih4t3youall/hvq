package ar.com.sourcesistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.sourcesistemas.model.Expense;;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	void deleteById(long id);
}
