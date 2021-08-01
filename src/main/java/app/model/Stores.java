package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(property = "StoreId", generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
@Table(name = "STORES")
public class Stores implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQ_NAME = "STORES_SEQ";

	@JsonProperty("StoreId")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
	@Column(name = "STORE_ID")
	private Integer storeId;
	
	@JsonProperty("storeName")
	@Column(name = "STORE_NAME")
	private String storeName;
	
	@JsonProperty("city")
	@Column(name = "CITY")
	private String city;
	
	@JsonProperty("street")
	@Column(name = "STREET")	
	private String street;
		
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
