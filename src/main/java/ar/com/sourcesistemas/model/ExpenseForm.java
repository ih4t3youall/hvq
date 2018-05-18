package ar.com.sourcesistemas.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ExpenseForm {

	@NotEmpty(message = "*Por favor ingrese  una descripcion")
	private String description;

	@NotNull(message = "*Por favor ingrese un monto")
	private double price;

	@NotNull(message = "*Por favor ingrese una fecha")

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@NotEmpty(message = "*Por favor ingrese una categoria")
	private String category;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
