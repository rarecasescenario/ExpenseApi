package app.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.MyCustomer;
import app.model.TestData;
import app.service.MyCustomerServiceImpl;

@RestController
@Produces(MediaType.APPLICATION_JSON)
public class MyCustomerController<MyCustomer> {

	private static final Logger log = LogManager.getLogger(MyCustomerController.class);
	
	@Autowired
	MyCustomerServiceImpl mcs;
	
//	@RequestMapping(value="/savecustomer", method=RequestMethod.POST)
//	public MyCustomer saveCustomer(@RequestBody MyCustomer mc) {
//		mcs.saveCustomer(mc);
//		return null;
//	}
	
	
	@RequestMapping("/getallcustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MyCustomer> getAll() {
		return (List<MyCustomer>) mcs.getAllCustomers();
	}
	
	
	@RequestMapping("/getcustomercount")
	@Produces(MediaType.APPLICATION_JSON)
	public Integer getCustomerCount() {
		log.info("/getcustomercount worked...");
		return mcs.getCustomerCount(); 
	}
}
