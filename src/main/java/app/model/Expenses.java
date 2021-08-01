package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(property = "ExpenseId", generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
@Table(name = "EXPENSES")
public class Expenses implements Serializable {

	private static final long serialVersionUID = 4477408449403987683L;

	@JsonProperty("ExpenseId")
	@Id
	@SequenceGenerator(name="seq", sequenceName="EXPENSES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
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
	@ManyToOne
	@JoinColumn(name = "STORE_ID")
	private Stores storeId;
	
	@JsonProperty("Code")
	@ManyToOne
	@JoinColumn(name = "CODE")
	private T2Codes code;
	
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
	
	public T2Codes getCode() {
		return code;
	}
	public void setCode(T2Codes code) {
		this.code = code;
	}
	public Stores getStoreId() {
		return storeId;
	}
	public void setStoreId(Stores storeId) {
		this.storeId = storeId;
	}

}
