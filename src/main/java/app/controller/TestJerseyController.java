package app.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import app.model.MyCustomer;
import app.service.MyCustomerServiceImpl;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TestJerseyController {

	@Autowired
	MyCustomerServiceImpl mcs;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Jersey has started normal...";
	}

	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MyCustomer> getAllCustomers() {
		return (List<MyCustomer>) mcs.getAllCustomers();
	}
	
	@Path("customer/{id}")
	@GET
	public List<MyCustomer> getAllCustomers(@PathParam(value="id") String id) {
		return (List<MyCustomer>) mcs.getCustomerById(id);
	}
	
	@Path("cust/{id}")
	@GET
	public Response getOneCustomers(@PathParam("id") String id) {
		return Response.ok((List<MyCustomer>) mcs.getCustomerById(id)).build();
	}
	
	@Path("names")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getNames() {
		return mcs.getCustomerNames();
	}

	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getNames(@PathParam("customerName") String customerName) {
		System.out.println("Got: " + customerName);
	}
}
