package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.model.MyCustomer;

@Service
public interface MyCustomerService {

//	void saveCustomer(MyCustomer mc);
	List<MyCustomer> getAllCustomers();
	Integer getCustomerCount();
	List<MyCustomer> getCustomerById(String id);
	List<String> getCustomerNames();
}
