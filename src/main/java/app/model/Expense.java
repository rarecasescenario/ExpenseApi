package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "EXPENSES")
public class Expense implements Serializable {

	private static final long serialVersionUID = 3310814267110505808L;
	private static final String SEQ_NAME = "EXPENSES_SEQ";

	@JsonProperty("ExpenseId")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
	@Column(name = "EXPENSE_ID")
	private Long expenseId;
	
	@JsonProperty("Product")
	@Column(name = "PRODUCT")
	private String product;
	
	@JsonProperty("Amount")
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@JsonProperty("TransactionDate")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	@Column(name = "TRANSACTION_DATE")
	private Date transactionDate;
	
	@JsonProperty("PaymentMethod")
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	
	@JsonProperty("StoreId")
	@Column(name = "STORE_ID")
	private Integer storeId;
	
	@JsonProperty("Code")
	@Column(name = "CODE")
	private Integer code;

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	
}
