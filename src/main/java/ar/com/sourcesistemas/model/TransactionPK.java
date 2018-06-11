
package ar.com.sourcesistemas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the transaction database table.
 * 
 */
@Embeddable
public class TransactionPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "income_id_expense", insertable = false, updatable = false)
	private int incomeIdExpense;

	@Column(name = "product_product_id", insertable = false, updatable = false)
	private int productProductId;

	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;

	public TransactionPK() {
	}

	public int getIncomeIdExpense() {
		return this.incomeIdExpense;
	}

	public void setIncomeIdExpense(int incomeIdExpense) {
		this.incomeIdExpense = incomeIdExpense;
	}

	public int getProductProductId() {
		return this.productProductId;
	}

	public void setProductProductId(int productProductId) {
		this.productProductId = productProductId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TransactionPK)) {
			return false;
		}
		TransactionPK castOther = (TransactionPK) other;
		return (this.incomeIdExpense == castOther.incomeIdExpense)
				&& (this.productProductId == castOther.productProductId) && (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.incomeIdExpense;
		hash = hash * prime + this.productProductId;
		hash = hash * prime + this.userId;

		return hash;
	}
}