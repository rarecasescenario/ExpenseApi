package app.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
@NamedNativeQueries({
	
	@NamedNativeQuery(name="ExpenseSearchView.search", query = "SELECT e.expense_id, e.product, e.amount, e.code, s.store_id" + 
			"  FROM expenses e," + 
			"  stores s," + 
			"  t2_codes t" + 
			"  WHERE e.store_id = s.store_id" + 
			"  AND e.code = t.code" + 
			"  AND e.code >= :id", resultSetMapping = "ExpenseSearchView.joinMapping")
})
@SqlResultSetMapping(name = "ExpenseSearchView.joinMapping" , 
	entities = {
		@EntityResult(entityClass = ExpenseSearchView.class, fields = {})
})
public class ExpenseSearchView implements Serializable {

	private static final long serialVersionUID = 87442107711759500L;

	@JsonView(Summary.class)
	@JsonProperty("expenseId")
	private Long expenseId;
	
	@JsonView(Summary.class)
	@JsonProperty("product")
	private String product;
	
	@JsonView(Summary.class)
	@JsonProperty("amount")	
	private BigDecimal amount;
	
	@JsonView(Summary.class)
	@JsonProperty("t2Code")
	@JsonIdentityReference
	@OneToMany
	@JoinColumn(name = "CODE")
	private T2Codes t2Code;

	@JsonView(Summary.class)
	@JsonProperty("store")
	@JsonIdentityReference
	@OneToMany
	@JoinColumn(name = "STORE_ID")
	private Stores store;
	
	@Id
	@Column(name = "EXPENSE_ID")
	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	@Column(name = "PRODUCT")
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "AMOUNT")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public T2Codes getT2Code() {
		return t2Code;
	}

	public void setT2Code(T2Codes t2Code) {
		this.t2Code = t2Code;
	}

	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

}
