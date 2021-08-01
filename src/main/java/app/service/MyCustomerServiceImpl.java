package app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.MyCustomer;
import app.repository.MyCustomerRepository;

@Service
public class MyCustomerServiceImpl implements MyCustomerService {

	@Autowired
	MyCustomerRepository mcr;
	
//	public void saveCustomer(MyCustomer mc) {
//		mcr.save(mc);
//	}
	
	public List<MyCustomer> getAllCustomers() {
		return mcr.findAll();
	}
	
	public Integer getCustomerCount() {
		List<MyCustomer> cl = mcr.findAll();
		return cl.size();
	}

	@Override
	public List<MyCustomer> getCustomerById(String id) {
		List<MyCustomer> cl = mcr.findAll();
		List<MyCustomer> r = cl.stream().filter(t -> t.getId().toString().equals(id)).collect(Collectors.toList());
		return r;
	}

	
	@Override
	public List<String> getCustomerNames() {
		List<MyCustomer> cl = mcr.findAll();
		List<String> r = cl.stream().map(t -> t.getName()).collect(Collectors.toList());
		return r;
	}
	
}
