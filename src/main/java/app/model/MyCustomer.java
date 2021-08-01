package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity(name="mycustomer")
@Table(name="MY_CUSTOMER")
@JsonIgnoreProperties({"hibernatelazyInitializer","handler"})
public class MyCustomer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="seq", sequenceName="MY_CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CITY")
	private String city;

	public MyCustomer() {
		super();
	}
	
	public MyCustomer(Long id, String name, int age, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer: " + name + " Age: " + age + " City: " + city;
		
	}
}
