package ar.com.sourcesistemas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the income database table.
 * 
 */
@Entity
@NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i")
public class Income implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "income_id")
	private int income_id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "pay_with")
	private String payWith;

	private String total;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "income", fetch = FetchType.EAGER)
	private List<Transaction> transactions;

	public Income() {
	}

	public int getIncome_id() {
		return income_id;
	}

	public void setIncome_id(int income_id) {
		this.income_id = income_id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPayWith() {
		return this.payWith;
	}

	public void setPayWith(String payWith) {
		this.payWith = payWith;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setIncome(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setIncome(null);

		return transaction;
	}

}