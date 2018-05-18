package ar.com.sourcesistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id")
	private String id;
	@Column(name = "description")
	private String description;
	@OneToMany(mappedBy = "category") // PONER EL NOMBRE DE VARIABLE DE La categoria EN expense, FOREIGN KEY DE
										// expense (EL ALIAS)
	private List<Expense> expenses;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

}
