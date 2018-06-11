package ar.com.sourcesistemas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionPK id;

	@Temporal(TemporalType.DATE)
	private Date date;

	// bi-directional many-to-one association to Income
	@ManyToOne
	@JoinColumn(name = "income_id")
	private Income income;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Transaction() {
	}

	public TransactionPK getId() {
		return this.id;
	}

	public void setId(TransactionPK id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Income getIncome() {
		return this.income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}