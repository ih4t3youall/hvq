package ar.com.sourcesistemas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expense_id")
	private long id;
	@Column(name = "description")
	@NotEmpty(message = "*Por favor ingrese  una descripcion")
	private String description;
	@Column(name = "price")
	@NotNull(message = "*Por favor ingrese un monto")
	private double price;
	@Column(name = "date")
	@NotNull(message = "*Por favor ingrese una fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "id_user") // ESPECIFICAR EL FOREIGN KEY EN ESTA MISMA TABLA
	private User user;

	@ManyToOne
	@JoinColumn(name = "id_category") // ESPECIFICAR EL FOREIGN KEY EN ESTA MISMA TABLA
	private Category category;

	private String categoryId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		this.categoryId = category.getId();
	}

	public String getCategoryId() {
		return categoryId;
	}

}
